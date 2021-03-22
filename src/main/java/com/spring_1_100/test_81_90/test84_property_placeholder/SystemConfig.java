package com.spring_1_100.test_81_90.test84_property_placeholder;

public class SystemConfig {

    private int sessionTimeout ;
    private int maxTabPageNum;


    public void initFromDB(){
        this.sessionTimeout = 30 ;
        this.maxTabPageNum = 10;
    }

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public int getMaxTabPageNum() {
        return maxTabPageNum;
    }

    public void setMaxTabPageNum(int maxTabPageNum) {
        this.maxTabPageNum = maxTabPageNum;
    }
}
