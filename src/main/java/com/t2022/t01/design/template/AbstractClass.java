package com.t2022.t01.design.template;

public abstract class AbstractClass  {
    public void operation(){
        System.out.println(" pre ");
        System.out.println(" step1 ");
        System.out.println(" step2 ");
        templateMehthod();
    }

    abstract  protected  void templateMehthod();
}
