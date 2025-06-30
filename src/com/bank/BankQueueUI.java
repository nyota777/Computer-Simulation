package com.bank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class BankQueueUI extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private JLabel averageWaitLabel;
    private JLabel totalIdleLabel;

    public BankQueueUI() {
        setTitle("Bank Queue Simulation");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Button to trigger simulation
        JButton simulateBtn = new JButton("Run Simulation");
        simulateBtn.addActionListener(e -> runSimulation());

        // Set up table
        String[] columnNames = {"ID", "Arrival", "Service", "Start", "End", "Wait", "Idle"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // Bottom labels
        averageWaitLabel = new JLabel("Average Wait Time: ");
        totalIdleLabel = new JLabel("Total Idle Time: ");

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        bottomPanel.add(averageWaitLabel);
        bottomPanel.add(totalIdleLabel);

        // Add components to frame
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(simulateBtn, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void runSimulation() {
        Simulator sim = new Simulator();
        List<Customer> customers = sim.runSimulation();

        // Clear previous data
        tableModel.setRowCount(0);

        // Populate table with new data
        for (Customer c : customers) {
            tableModel.addRow(new Object[]{
                    c.id,
                    String.format("%.2f", c.arrivalTime),
                    String.format("%.2f", c.serviceTime),
                    String.format("%.2f", c.serviceStartTime),
                    String.format("%.2f", c.serviceEndTime),
                    String.format("%.2f", c.waitingTime),
                    String.format("%.2f", c.idleTime)
            });
        }

        // Update labels
        averageWaitLabel.setText("Average Wait Time: " + String.format("%.2f", sim.getAverageWaitTime()));
        totalIdleLabel.setText("Total Idle Time: " + String.format("%.2f", sim.getTotalIdleTime()));

        // Open chart window
        showCharts(customers);
    }

    private void showCharts(List<Customer> customers) {
        JFrame chartFrame = new JFrame("Queue Visualizations");
        chartFrame.setSize(1000, 600);
        chartFrame.setLayout(new GridLayout(2, 1));

        chartFrame.add(ChartUtils.createWaitingTimeChart(customers));
        chartFrame.add(ChartUtils.createIdleTimeChart(customers));

        chartFrame.setVisible(true);
    }
}
