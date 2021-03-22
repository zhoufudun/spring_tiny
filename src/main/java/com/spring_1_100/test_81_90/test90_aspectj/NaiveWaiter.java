package com.spring_1_100.test_81_90.test90_aspectj;

public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name + " ... ");
    }

    @Override
    public void serviceTo(String name) {
        System.out.println("serving " + name + " ... ");
    }


}
