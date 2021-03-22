package com.spring_1_100.test_11_20.test12_constructor_arg;

public class Car {
    private String brand;
    private String color;
    private int maxSpeed;
    private double maxSpeed1;

    public Car() {

    }




    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public Car(String brand, String color, double maxSpeed1) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed1 = maxSpeed1;
    }


    public void introduce() {
        System.out.println("brand:" + brand + ";color:" + color + ";maxSpeed:" + maxSpeed);
    }



    public void setBrand(String brand) {
        this.brand = brand;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }


    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getMaxSpeed1() {
        return maxSpeed1;
    }

    public void setMaxSpeed1(double maxSpeed1) {
        this.maxSpeed1 = maxSpeed1;
    }
}
