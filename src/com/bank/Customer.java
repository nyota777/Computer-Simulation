package com.bank;

public class Customer {
    public int id;
    public double arrivalTime;
    public double serviceTime;
    public double serviceStartTime;
    public double serviceEndTime;
    public double waitingTime;
    public double idleTime;

    public Customer(int id, double arrivalTime, double serviceTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }
}
