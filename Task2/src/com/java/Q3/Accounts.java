package com.java.Q3;
public class Accounts {

    //    Variable Declaration
    final String accNum;
    private double bal;

    //    Parameterized Constructor
    public Accounts(String accNum, double bal) {
        this.accNum = accNum;
        this.bal = bal;
    }

    //    Method to Deposit Amount
    public void deposit(double amt) {
        bal += amt; // Add amount to balance and assign to balance
        System.out.println("Account Number: " + this.accNum);
        System.out.println("Amount deposited successfully");
        System.out.println("Your current balance is  Rs." + displayBalance());
    }

    //    Method to Withdraw Amount
    public void withdraw(double amt) {
        System.out.println("Account Number: " + this.accNum);
        if (bal >= amt) { // Check if the balance is greater than the amount
            bal -= amt; // if yes subtract amount from balance and assign the value to balance
            System.out.println("Please collect your cash");
            System.out.println("Your current balance is  Rs." + displayBalance());
        } else { // Else print insufficient fund
            System.out.println("Insufficient Balance in your account. Please try again");
        }
    }

    //    Method to Display Balance that returns double 'balance'
    public double displayBalance() {
        return bal;
    }
}