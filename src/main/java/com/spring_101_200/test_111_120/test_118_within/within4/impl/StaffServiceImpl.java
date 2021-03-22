package com.spring_101_200.test_111_120.test_118_within.within4.impl;

import com.spring_101_200.test_111_120.test_118_within.within4.MyAnnotation;
import com.spring_101_200.test_111_120.test_118_within.within4.StaffService;
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
