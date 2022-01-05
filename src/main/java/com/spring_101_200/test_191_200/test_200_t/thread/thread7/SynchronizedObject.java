package com.spring_101_200.test_191_200.test_200_t.thread.thread7;

public class SynchronizedObject  {
    private String username = "a";
    private String password = "aa";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    synchronized  public void printString(String username,String password){
        this.username = username;
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
    }


}
