package com.spring_1_100.test_61_70.test64_2.impl;

import com.spring_1_100.test_61_70.test64_2.MyAnnotation;
import com.spring_1_100.test_61_70.test64_2.StaffService;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {


    @Override
    public void getStaffName() {
        System.out.println("getStaffName");
    }

    @Override
    @MyAnnotation
    public void getStaffInfo() {
        System.out.println("getStaffInfo");
    }
}
