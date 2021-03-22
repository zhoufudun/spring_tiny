package com.spring_1_100.test_81_90.test88_advisor;

public class WaiterDelegate  {
    private Waiter waiter;

    public void service(String clientName){
        waiter.greetTo(clientName);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        waiter.serviceTo(clientName);
    }


    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

}
