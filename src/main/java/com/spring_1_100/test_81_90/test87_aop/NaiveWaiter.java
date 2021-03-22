package com.spring_1_100.test_81_90.test87_aop;

public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        int i = 0 ;
        int j = 1 ;
        int c = j / i ;
        System.out.println("greet to " + name + " ... ");
    }

    @Override
    public void serviceTo(String name) {
        System.out.println("serving " + name + " ... ");
    }


}
