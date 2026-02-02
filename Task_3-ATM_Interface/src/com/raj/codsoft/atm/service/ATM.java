package com.raj.codsoft.atm.service;

import com.raj.codsoft.atm.model.BankAccount;
import java.util.Scanner;

public class ATM {

    private final BankAccount account;
    private final Scanner scanner = new Scanner(System.in);

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        boolean running = true;

        while (running) {
            showMenu();
            System.out.print("Choose an option: ");
            int choice = getIntInput();

            switch (choice) {
                case 1 -> checkBalance();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> {
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n====== ATM MENU ======");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    private void checkBalance() {
        System.out.printf("Current Balance: ₹%.2f%n", account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = getDoubleInput();

        try {
            account.deposit(amount);
            System.out.println("Deposit successful.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = getDoubleInput();

        try {
            account.withdraw(amount);
            System.out.println("Withdrawal successful.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter a valid amount: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
