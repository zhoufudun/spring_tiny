package com.spring_101_200.test_121_130.test_127_mybatis_plugins;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerator;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private Integer isDelete;
    private Date gmtCreate;
    private Date gmtModified;
    private String username;
    private String password;
    private String realName;
    private Long managerId;




    public static User build(){
        User user = new User();
        return user;
    }

    public User uIsDelete(Integer isDelete){
        this.isDelete=    isDelete;
        return this;
    }

    public User uUsername(String  userName){
        this.username = userName;
        return this;
    }

    public static void main(String[] args) {
        User user = User.build().uIsDelete(1).uUsername("xxx");
        System.out.println(JSON.toJSONString(user));
    }

}
