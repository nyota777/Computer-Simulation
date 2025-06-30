package com.bank;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.List;

public class ChartUtils {

    public static JPanel createWaitingTimeChart(List<Customer> customers) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Customer c : customers) {
            dataset.addValue(c.waitingTime, "Waiting Time", "Customer " + c.id);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Customer Waiting Times",
                "Customer ID",
                "Waiting Time (minutes)",
                dataset
        );

        return new ChartPanel(chart);
    }

    public static JPanel createIdleTimeChart(List<Customer> customers) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Customer c : customers) {
            dataset.addValue(c.idleTime, "Idle Time", "Customer " + c.id);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Server Idle Time per Customer",
                "Customer ID",
                "Idle Time (minutes)",
                dataset
        );

        return new ChartPanel(chart);
    }
}
