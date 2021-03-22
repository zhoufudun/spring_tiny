package com.spring_101_200.test_111_120.test_117_excution.excution17.impl;


import com.spring_101_200.test_111_120.test_117_excution.excution17.Model;
import com.spring_101_200.test_111_120.test_117_excution.excution17.MyAnnotation;
import com.spring_101_200.test_111_120.test_117_excution.excution17.User;
import com.spring_101_200.test_111_120.test_117_excution.excution17.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public void getUserHomeWork(@MyAnnotation User zhangsan, @MyAnnotation User lizi) {
        System.out.println("getUserHomeWork zhangsan lisi:");
    }

    @Override
    public void getUserHomeInfo(@MyAnnotation User zhangsan, User lizi) {
        System.out.println("getUserHomeInfo wangwu zhaoliu");
    }



    @Override
    public void getModelInfo(@MyAnnotation Model zhangsan, @MyAnnotation Model lizi) {
        System.out.println("getModelInfo model ");
    }


}




