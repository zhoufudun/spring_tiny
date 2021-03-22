package com.spring_101_200.test_141_150.test_145_mybatis_cachenamespaceref_xml;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class User implements Serializable {

    private Long id;
    private int isDelete;
    private Date gmtCreate;
    private Date gmtModified;
    private String username;
    private String password;
    private String realName;
    private Long managerId;


}
