package com.vincentmegia;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void setPoisonPill() {
//        this.
    }
    @Override
    public void run() {
        try {
            for (var index = 0; index <= 1000000; index++) {
                var threadName = Thread.currentThread().getName();
                this.blockingQueue.add(new Message(String.valueOf(index), String.format("counter: %s", index)));
                System.out.println(String.format("producer-threadname: %s, counter: %s", threadName, index));
            }
            System.out.println("producer completed:");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
