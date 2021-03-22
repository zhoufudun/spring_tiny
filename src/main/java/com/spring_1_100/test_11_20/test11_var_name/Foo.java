package com.spring_1_100.test_11_20.test11_var_name;

public class Foo {
    // 非常的属性变量名，不过 java 语言本身不会报错，因为它将 iDCode 看成普通的变量
    // 新版本的代码没有这个问题
    private String iDCode ;

    public String getiDCode() {

        return iDCode;
    }

    public void setiDCode(String iDCode) {
        this.iDCode = iDCode;
    }
}
