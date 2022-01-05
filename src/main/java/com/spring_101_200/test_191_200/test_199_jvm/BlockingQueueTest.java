package com.spring_101_200.test_191_200.test_199_jvm;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueTest {

    public static void main(String[] args) {
        try {
            ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(1);
            blockingQueue.put("8932");
            blockingQueue.put("idosi");
            blockingQueue.put("8939829832");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
