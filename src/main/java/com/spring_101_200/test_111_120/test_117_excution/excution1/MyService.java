package com.spring_101_200.test_111_120.test_117_excution.excution1;


import com.spring_101_200.test_111_120.test_117_excution.excution0.ParentService;
import org.springframework.stereotype.Service;

@Service
public class MyService  extends ParentService {

    public void service() {
        System.out.println("self.serivce");
    }

}