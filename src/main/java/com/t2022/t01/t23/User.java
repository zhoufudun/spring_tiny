package com.t2022.t01.t23;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

@Data
public class User {
       private Integer age;
       public static void main(String[] args) {
           User user = new User() ;
           user.setAge(new Integer(1));
           System.out.println(new Integer(1) == user.getAge());
           System.out.println(1 == user.getAge());
       }
   }
