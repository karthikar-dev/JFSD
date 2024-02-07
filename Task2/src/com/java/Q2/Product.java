package com.java.Q2;

public class Product extends User {
    //    Variable Declaration
    protected int pid;
    protected double price;
    protected int quantity;

    //    Parameterized Constructor
    Product(int pid, double price, int quantity) {
        this.price = price;
        this.pid = pid;
        this.quantity = quantity;
    }
}
