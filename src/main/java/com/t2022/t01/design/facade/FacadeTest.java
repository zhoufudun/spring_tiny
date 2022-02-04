package com.t2022.t01.design.facade;

public class FacadeTest {


    public static void main(String[] args) {
        Client1 client1 = new Client1();
        client1.doSomething1();

        Client2 client2 = new Client2();
        client2.doSomething2();
    }
}
