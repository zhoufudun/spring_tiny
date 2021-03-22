package com.spring_101_200.test_131_140.test_132_mybatis_typehandlers;

import lombok.Data;
import org.apache.ibatis.builder.BuilderException;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.parsing.XNode;

import java.io.InputStream;
import java.util.Date;

@Data
public class User {
    private Long id;
    private Integer isDelete;
    private Date gmtCreate;
    private Date gmtModified;
    private PhoneNumber username;
    private String password;
    private String realName;
    private Long managerId;
    private Sex sex;
    private Sex sexStr;

}
