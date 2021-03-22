package com.spring_101_200.test_131_140.test_139_mybatis_saferesulthandlerenabled;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

public class MyDefaultResultSetHandler implements ResultHandler {


    @Override
    public void handleResult(ResultContext context) {
        System.out.println("=============================");
    }

}
