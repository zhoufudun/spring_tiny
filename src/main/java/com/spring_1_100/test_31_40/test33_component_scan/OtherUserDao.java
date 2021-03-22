package com.spring_1_100.test_31_40.test33_component_scan;


import org.springframework.stereotype.Service;

@Service("otherUserDao")
//@ExComponent

public class OtherUserDao implements UserDao {
}
