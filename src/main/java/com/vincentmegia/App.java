package com.vincentmegia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;


public class App 
{
    public static void main( String[] args ) throws IOException, ExecutionException, InterruptedException {
        var blockingQueueHelper = new BlockingQueueHelper();
        var blockingQueue = blockingQueueHelper.getBlockingQueue();
        var producer = new Producer(blockingQueue);
        var consumer1 = new Consumer(blockingQueue);
        var consumer2 = new Consumer(blockingQueue);
        var consumer3 = new Consumer(blockingQueue);
        var consumerExecutor1 = Executors.newSingleThreadExecutor();
        var consumerExecutor2 = Executors.newSingleThreadExecutor();
        var consumerExecutor3 = Executors.newSingleThreadExecutor();
        var producerExecutor = Executors.newSingleThreadExecutor();
        producerExecutor.submit(producer);
        Thread.sleep(10000);
        consumerExecutor1.submit(consumer1);
        consumerExecutor2.submit(consumer2);
        consumerExecutor3.submit(consumer3);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        blockingQueueHelper.getBlockingQueue().clear();
        consumer1.setPoisonPill();
        consumer2.setPoisonPill();
        consumer3.setPoisonPill();
        producerExecutor.shutdown();
        consumerExecutor1.shutdown();
        consumerExecutor2.shutdown();
        consumerExecutor3.shutdown();
    }
}
