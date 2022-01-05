package com.spring_101_200.test_191_200.test_200_t;

import java.io.Serializable;
import java.util.List;

public class OneTuple<A> implements Serializable {
    private A first;
    private List<A> aList;

    public OneTuple(A a) {
        first = a;
        aList.add(0,a);
    }


    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }


    public List<A> getaList() {
        return aList;
    }


    public void setaList(List<A> aList) {
        this.aList = aList;
    }
}

