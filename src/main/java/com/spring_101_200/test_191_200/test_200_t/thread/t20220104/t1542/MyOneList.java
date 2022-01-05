package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1542;

import java.util.ArrayList;
import java.util.List;

public class MyOneList {

    private List list = new ArrayList<>();


    synchronized public void add(String data) {
        list.add(data);
    }

    synchronized public int getSize() {
        return list.size();
    }


}
