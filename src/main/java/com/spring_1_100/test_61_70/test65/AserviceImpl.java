package com.spring_1_100.test_61_70.test65;

import org.springframework.stereotype.Service;

@Service
public class AserviceImpl implements Aservice {

    @Override
    public void b(String x,String y ) {

        System.out.println("print x=" + x + ",y="+y);

        int i = 1;
        int b = 0 ;
        int c = i /b   ;


    }
}
