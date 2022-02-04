package com.t2022.t01.design.singleton;

public class LazySingleton {


    private volatile static LazySingleton instance;


    private LazySingleton(){

    }


    public static LazySingleton getInstance(){
        if(instance == null){
            synchronized (LazySingleton.class){
                if(instance == null){
                    instance = new LazySingleton();
                    //字节码层
                    // JIT,CPU有可能对如下指令进行重新排序
                    // 1.分配空间
                    // 2.初始化
                    // 3.引用赋值
                    //如果排序后的结果如下
                    // 1.分配空间
                    // 2.引用赋值
                    // 3. 初始化
                    // 如果引用赋值，如果在当前指令执行完，有其他线程来获取实例，将拿到尚未初始化好的实例
                }
            }
        }
        return instance;
    }

}
