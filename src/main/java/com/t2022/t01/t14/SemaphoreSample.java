package com.t2022.t01.t14;

import java.util.concurrent.Semaphore;

public class SemaphoreSample {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            new Thread(new Task(semaphore, "yangguo" + i)).start();
        }
    }

    static class Task extends Thread {
        Semaphore semaphore;

        public Task(Semaphore semaphore, String name) {
            this.semaphore = semaphore;
            this.setName(name);
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + ":aquire() at time :" + System.currentTimeMillis());
                Thread.sleep(1000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + ":aquire() at time : " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}
