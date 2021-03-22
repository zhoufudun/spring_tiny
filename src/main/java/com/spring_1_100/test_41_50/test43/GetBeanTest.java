package com.spring_1_100.test_41_50.test43;

public abstract class GetBeanTest {
    public void showMe() {
        this.getBean().showMe();
    }
    public abstract Teacher getBean();
}

