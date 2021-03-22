package com.spring_101_200.test_121_130.test_128_mybatis_objectfactory;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

public class UserObjectFactory extends DefaultObjectFactory {

    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    //DefaultObjectFactory的create(Class type)方法也会调用此方法，所以只需要在此方法中添加逻辑即可
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T ret = super.create(type, constructorArgTypes, constructorArgs);
        if (User.class.isAssignableFrom(type)) {
            User entity = (User) ret;
            entity.init();
        }
        return ret;
    }


    public void setProperties(Properties properties) {
        System.out.println(JSON.toJSONString(properties));
    }
}