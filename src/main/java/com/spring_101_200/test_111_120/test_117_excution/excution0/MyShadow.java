package com.spring_101_200.test_111_120.test_117_excution.excution0;

import javax.xml.bind.SchemaOutputResolver;

public class MyShadow {


    // every Shadow has a unique id, doesn't matter if it wraps...
    private static int nextShadowID = 100; // easier to spot than zero. // OPTIMIZE is this a bug? static?


    public int shadowId = nextShadowID++; // every time we build a shadow, it gets a new id

    public MyShadow(){

    }

    public MyShadow(MyShadow myShadow){

    }


    public static void main(String[] args) {

        MyShadow myShadow = new MyShadow();
        MyShadow myShadow1 = new MyShadow();
        System.out.println(myShadow.shadowId);
        System.out.println(myShadow1.shadowId);



    }
}
