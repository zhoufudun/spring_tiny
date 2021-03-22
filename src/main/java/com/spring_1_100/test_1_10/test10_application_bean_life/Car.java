package com.spring_1_100.test_1_10.test10_application_bean_life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String brand;
    private String color ;
    private int maxSpeed ;

    private BeanFactory beanFactory ;
    private String beanName ;

    public Car() {
        System.out.println("调用 Car() 构造函数");
    }

    public void setBrand(String brand){
        System.out.println("调用 setBrand()设置的属性");
        this.brand = brand;
    }

    public void introduce(){
        System.out.println("brand :" + brand + ";color:" +color + ";maxSpped:" + maxSpeed);
    }



    // BeanFactoryAware 接口方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用 BeanFactoryAware.setBeanFactory() ");
        this.beanFactory = beanFactory;
    }

    // BeanNameAware 接口方法
    @Override
    public void setBeanName(String beanName) {
        System.out.println("调用 BeanNameAware.setBeanName()  ");
        this.beanName = beanName;
    }


    // InitializingBean 接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用 InitializingBean.afterPropertiesSet()");
    }

    // DisposableBean 接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("调用 DisposableBean.destroy() ");
    }
    // 通过 bean 的 init-method 属性指定初始化方法
    public void myInit(){
        System.out.println("调用 init-method 所指定的 myinit() ，将 maxSpeed 设置为 240 。");
        this.maxSpeed = 240;
    }
    // 通过 bean 的 destory-method 属性指定销毁方法
    public void myDestroy(){
        System.out.println("调用 destory-method 所指定的 myDestory() 方法");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
