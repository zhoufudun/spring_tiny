package com.spring_101_200.test_181_190.test_184;

public abstract class MyFrameDisplay {

    public void a() {

    }

    public class MyContextRefreshListener implements MyApplicationListener {
        @Override
        public void test() {
            MyFrameDisplay.this.a();
        }
    }


}
