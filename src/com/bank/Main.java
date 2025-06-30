package com.bank;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            BankQueueUI ui = new BankQueueUI();
            ui.setVisible(true);
        });
    }
}
