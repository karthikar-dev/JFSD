package com.java;

import java.util.Scanner;

public class Bank extends Account{
    //    Parameterized Constructor
    public Bank(String accNum, double bal) {
        super(accNum, bal);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //        Getting account Number from the user
        System.out.println("Please enter the account number");
        String accNum = sc.nextLine();

        //      Object creation for the class
        Bank bank = new Bank(accNum, 500);
        bank.displayOptions(bank, sc);
    }

    //    Method to display the Banking Options
    public void displayOptions(Bank bank, Scanner sc) {
        System.out.println("Please select one from the below option");
        System.out.println("1. Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");

        //      Getting the input from the user
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println("Your current balance is  Rs." + this.displayBalance());
                break;
            case 2:
                System.out.println("Please enter the amount you want to deposit");
                double d_amt = sc.nextDouble();
                this.deposit(d_amt);
                break;
            case 3:
                System.out.println("Please enter the amount for withdrawal");
                double w_amt = sc.nextDouble();
                this.withdraw(w_amt);
                break;
            default:
                System.out.println("Option not available. Please try again");
                // Recursive Function
                bank.displayOptions(bank, sc);
                break;
        }
    }
}
