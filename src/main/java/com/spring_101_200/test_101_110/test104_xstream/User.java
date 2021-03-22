package com.spring_101_200.test_101_110.test104_xstream;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement
public class User {


    private Long userId;
    private String username;
    private List<LoginLog> logs;


}
