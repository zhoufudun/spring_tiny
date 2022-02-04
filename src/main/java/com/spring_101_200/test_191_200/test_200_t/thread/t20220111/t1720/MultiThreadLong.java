package com.spring_101_200.test_191_200.test_200_t.thread.t20220111.t1720;

public class MultiThreadLong {

    public static long t = 0;

    public static class ChangeT implements Runnable {

        private long to;

        public ChangeT(long to) {
            this.to = to;
        }

        @Override
        public void run() {
            while (true) {
                MultiThreadLong.t = to;
                Thread.yield();
            }
        }
    }

    public static class ReadT implements Runnable {

        @Override
        public void run() {
            while (true) {
                long temp = MultiThreadLong.t;
                if (temp != 111L && temp != -999l && temp != 333l && temp != -444l) {
                    System.out.println(temp);
                    Thread.yield();
                }
            }
        }
    }


    // 这里截取部分输出，我们可以看到，读取线程居然讲到了两个似乎根本不可能存在的数字，这里不是幻觉，在这里，你看到的确实是事实，因为在32位
    // 系统中long 型的数据的计和写都不是原子性的，多线程之间相互干扰了
    public static void main(String[] args) {
        new Thread(new ChangeT(111l)).start();
        new Thread(new ChangeT(-999l)).start();
        new Thread(new ChangeT(333l)).start();
        new Thread(new ChangeT(-444l)).start();

        new Thread(new ReadT()).start();
    }
}
