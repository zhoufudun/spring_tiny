package com.spring_101_200.test_191_200.test_200_t;

import java.util.List;

public class TwoTuple<A, B> extends OneTuple<A> {
    private B second;

    private List<B> bList;

    public TwoTuple(A a, B b) {
        super(a);
        second = b;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    public List<B> getbList() {
        return bList;
    }

    public void setbList(List<B> bList) {
        this.bList = bList;
    }
}

