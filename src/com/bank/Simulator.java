package com.bank;

import java.util.*;

public class Simulator {
    private final int NUM_CUSTOMERS = 100;
    private final double MIN_ARRIVAL = 1.0;
    private final double MAX_ARRIVAL = 8.0;
    private final double MIN_SERVICE = 1.0;
    private final double MAX_SERVICE = 6.0;
    private final List<Customer> customers = new ArrayList<>();
    private final Random random = new Random();

    public List<Customer> runSimulation() {
        customers.clear();  // Clear any previous data

        for (int i = 0; i < NUM_CUSTOMERS; i++) {
            double arrival = i == 0 ? getRandom(MIN_ARRIVAL, MAX_ARRIVAL)
                    : customers.get(i - 1).arrivalTime + getRandom(MIN_ARRIVAL, MAX_ARRIVAL);
            double service = getRandom(MIN_SERVICE, MAX_SERVICE);

            Customer c = new Customer(i + 1, arrival, service);

            if (i == 0) {
                c.serviceStartTime = c.arrivalTime;
                c.idleTime = c.arrivalTime;
            } else {
                Customer prev = customers.get(i - 1);
                c.serviceStartTime = Math.max(c.arrivalTime, prev.serviceEndTime);
                c.idleTime = Math.max(0, c.serviceStartTime - prev.serviceEndTime);
            }

            c.waitingTime = c.serviceStartTime - c.arrivalTime;
            c.serviceEndTime = c.serviceStartTime + c.serviceTime;

            customers.add(c);
        }

        return customers;
    }

    public double getAverageWaitTime() {
        return customers.stream()
                .mapToDouble(c -> c.waitingTime)
                .average()
                .orElse(0.0);
    }

    public double getTotalIdleTime() {
        return customers.stream()
                .mapToDouble(c -> c.idleTime)
                .sum();
    }

    private double getRandom(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }
}
