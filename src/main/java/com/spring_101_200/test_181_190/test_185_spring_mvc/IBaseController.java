package com.spring_101_200.test_181_190.test_185_spring_mvc;


import org.springframework.web.bind.annotation.RequestMapping;

import javax.sound.midi.Soundbank;

public interface IBaseController {



    @RequestMapping("/a")
    default void a (){
        System.out.println("======================");
    }


}
