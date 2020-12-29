package com.vincentmegia;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueHelper {
    private BlockingQueue blockingQueue;

    public BlockingQueueHelper() {
        this.blockingQueue = new LinkedBlockingQueue(Integer.MAX_VALUE);
    }

    public BlockingQueue getBlockingQueue() {
        return this.blockingQueue;
    }
}
