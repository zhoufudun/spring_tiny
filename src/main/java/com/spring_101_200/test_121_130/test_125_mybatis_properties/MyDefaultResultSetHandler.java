package com.spring_101_200.test_121_130.test_125_mybatis_properties;


import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.*;

public class MyDefaultResultSetHandler implements ResultHandler {

    private Map<String, List<User>> resultMap = new HashMap<>();

    @Override
    public void handleResult(ResultContext context) {
        Object object = context.getResultObject();
        System.out.println("========"+object);
        if (object instanceof User) {
            User user = (User)object;
            List<User> userList = resultMap.get(user.getRealName());
            if(userList == null){
                userList = new ArrayList<>();
            }
            userList.add(user);
            resultMap.put(user.getRealName(),userList);
        }

    }


    public Map<String, List<User>> getResultMap() {
        return resultMap;
    }
}
