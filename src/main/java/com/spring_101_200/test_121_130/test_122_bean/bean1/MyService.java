package com.spring_101_200.test_121_130.test_122_bean.bean1;

import com.spring_1_100.test_61_70.test64_2.MyAnnotation;
import org.springframework.stereotype.Service;

@Service
public class MyService {


    public void service(){
        System.out.println("---------serivce");
    }



    @MyAnnotation
    public void select(){
        System.out.println("---------select-------");
    }
}
