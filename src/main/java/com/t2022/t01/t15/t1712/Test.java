package com.t2022.t01.t15.t1712;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {

    public static void main(String[] args) throws Exception {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
        queue.put(1);
        Integer a = queue.take();
        Integer b = queue.take();
        System.out.println(a);
        System.out.println(b);
    }
}
