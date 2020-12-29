package com.vincentmegia;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue blockingQueue;
    private int poisonPill;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void setPoisonPill() {
        this.poisonPill = -1;
    }

    @Override
    public void run() {
        try {
            var threadName = Thread.currentThread().getName();
            while (poisonPill != -1) {
                while (this.blockingQueue.size() > 0) {
                    var message = (Message) this.blockingQueue.take();
                    System.out.println(String.format("consumer-threadname: %s, message: %s", threadName, message.getMessage()));
                }
            }
            System.out.println("consumer-thread exiting blockingqueue loop");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
