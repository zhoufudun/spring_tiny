package com.t2022.t01.design.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class InnerClassSingleton2 implements Serializable {

    static final long serialVersionUID = 42l;

    private static class InnclassHolder {
        private static InnerClassSingleton2 instance = new InnerClassSingleton2();
    }


    private InnerClassSingleton2() {
        if (InnclassHolder.instance != null) {
            throw new RuntimeException("单例不允许有多个实例");
        }
    }


    public static InnerClassSingleton2 getInstance() {
        return InnclassHolder.instance;
    }


    Object readResolve() throws ObjectStreamException {
        return InnclassHolder.instance;
    }


    public static void main(String[] args) {

    }
}
