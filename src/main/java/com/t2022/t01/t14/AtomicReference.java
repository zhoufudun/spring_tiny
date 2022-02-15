package com.t2022.t01.t14;

import java.io.Serializable;

public class AtomicReference <V> implements Serializable {

    private volatile  V value;
    //省略其他代码
    public AtomicReference(V value) {
        this.value = value;
    }
}
