package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1542;

public class MyService  {
    public MyOneList addServiceMethod(MyOneList list , String data ){
        try {
            // 脏读 出现了，出现的原因是两个线程以异步的方式返回list参数的size()大小，解决办法就是同步化
            synchronized (list){
                if(list.getSize() < 1 ){
                    Thread.sleep(2000);
                    list.add(data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}
