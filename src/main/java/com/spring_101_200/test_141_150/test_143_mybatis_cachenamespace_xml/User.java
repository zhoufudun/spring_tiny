package com.spring_101_200.test_141_150.test_143_mybatis_cachenamespace_xml;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    //
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Integer isDelete;
    //创建时间
    private Date gmtCreate;
    //
    private Date gmtModified;
    //用户名
    private String username;
    //密码
    private String password;
    //
    private String realName;
    //管理员id
    private Long managerId;
    //性别
    private Integer sex;
    //
    private String sexStr;

}
