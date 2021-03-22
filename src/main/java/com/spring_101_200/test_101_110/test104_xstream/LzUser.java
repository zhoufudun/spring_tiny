package com.spring_101_200.test_101_110.test104_xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import lombok.Data;

import java.util.Date;

@XStreamAlias("user")
@Data
public class LzUser {

    @XStreamAsAttribute
    @XStreamAlias("id")
    private int userId;

    @XStreamAlias("username")
    private String userName;

    @XStreamAlias("password")
    private String password;

    @XStreamAlias("credits")
    private int credits;

    @XStreamAlias("lastIp")
    private String lastIp;

    @XStreamConverter(value = DateConverter.class)
    private Date lastVisit;


}
