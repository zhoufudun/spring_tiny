package com.spring_101_200.test_111_120.test_117_excution.excution2;

import com.utils.LogUtils;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public MyService(){
        LogUtils.all("init");
    }

    protected void service() {

        System.out.println("serivce");
    }


}