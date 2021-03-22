package com.spring_1_100.test_31_40.test37;

public class TestB {
    private TestC testC;
    public TestB() {
    }
    public TestB(TestC testC) {
        this.testC = testC;
    }
    public TestC getTestC() {
        return testC;
    }
    public void setTestC(TestC testC) {
        this.testC = testC;
    }
}
