package com.spring_101_200.test_191_200.test_200_t;


import java.io.Serializable;

public class Tuple<A,B> implements Serializable {

    private TwoTuple data;

    public Tuple() {
        this.data = new TwoTuple(null,null);
    }

    public TwoTuple getData() {
        return data;
    }

    public void setData(TwoTuple data) {
        this.data = data;
    }


    public A get(int a ){
        return null;
    }

    public B get(char a ){

        return null;
    }

    public static void main(String[] args) {
        Tuple<String,Integer> tuple = new Tuple<>();
        String a = tuple.get(1);
    }
}
