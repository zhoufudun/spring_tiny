package com.spring_101_200.test_141_150.test_148_mybatis_selectprovider;

public class SqlProvider {
    public String selectUser(Long userId){

       return "select * from lz_user where id = " + userId;

    }


}
