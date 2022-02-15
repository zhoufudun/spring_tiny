package com.t2022.t01.t14;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private int index;

    public CyclicBarrierTest(CyclicBarrier cyclicBarrier, int index) {
        this.cyclicBarrier = cyclicBarrier;
        this.index = index;
    }

    @Override
    public void run() {
        try {
            System.out.println("index :" + index);
            index--;
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } finally {
        }
    }


    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(11, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有特工到达屏障，准备开始执行秘密任务 ");
            }
        });
        for (int i = 0; i < 10; i++) {
            new Thread(new CyclicBarrierTest(cyclicBarrier, i)).start();
        }
        cyclicBarrier.await();
        System.out.println("全部达到屏障 ...");
    }
}
