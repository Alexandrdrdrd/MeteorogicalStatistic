package com.company;

public class WindInformation {
    String name;
    int count;


    public void setCount(int count) {
        this.count = count;
    }

    public void setSumOfSpeed(double sumOfSpeed) {
        this.sumOfSpeed = sumOfSpeed;
    }

    double sumOfSpeed;


    public WindInformation(String name) {
        this.name = name;

    }


    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public double getSumOfSpeed() {
        return sumOfSpeed;
    }


}
