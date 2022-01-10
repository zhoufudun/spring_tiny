package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1009;

import java.io.*;

public class MyObject implements Serializable {


    private static final long serialVersionUID = 5538965493001900432L;

    // 内部类方式
    private static class MyObjectHandler {
        private final static MyObject myObject = new MyObject();
    }

    private MyObject() {

    }

    public static MyObject getInstance() {
        return MyObjectHandler.myObject;

    }


    protected Object readResolve() throws ObjectStreamException {
        System.out.println(" 调用了 readResolve ");
        return MyObjectHandler.myObject;
    }

    public static void main(String[] args) throws Exception {
        MyObject myObject = MyObject.getInstance();
        FileOutputStream fosRef = new FileOutputStream(new File("myObjectFile.txt"));
        ObjectOutputStream ossRef = new ObjectOutputStream(fosRef);
        ossRef.writeObject(myObject);
        ossRef.close();
        fosRef.close();
        System.out.println(myObject.hashCode());


        FileInputStream fisRef = new FileInputStream(new File("myObjectFile.txt"));
        ObjectInputStream iosRef = new ObjectInputStream(fisRef);
        MyObject myObject1 = (MyObject) iosRef.readObject();
        iosRef.close();
        fisRef.close();
        System.out.println(myObject1.hashCode());


    }
}
