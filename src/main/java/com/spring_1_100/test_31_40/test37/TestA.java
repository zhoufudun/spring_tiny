package com.spring_1_100.test_31_40.test37;

public class TestA {

    private TestB testB;


    public TestA() {
    }

    public TestA(TestB testB) {
        this.testB = testB;
    }

    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }
}
