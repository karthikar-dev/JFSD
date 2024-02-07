/*
    Create Interface Taxable with members sales Tax-7% and income Tax=10.5%, create abstract method calc Tax().
    a. Create class Employee (empld,name, salary) and implement Taxable to calculate income Tax on yearly salary.
    b. Create class Product(pid,price, quantity) and implement Taxable to calculate sales Tax on unit price of product.
    c. Create class for main method(Say XYZ), accept employee information and a product information from user and
    print income tax and sales tax respectively

 */

package com.java.Q2;

import java.util.Scanner;

// Interface
interface Taxable {
    int salesTaxPercentage = 7;
    int incomeTaxPercentage = 10;
    void calcTax(); // Abstract Method
}
class Product implements Taxable {

//    Variable Declaration for Product Class
    int pId;
    float price;
    int quantity;
    float calTax;

//    Constructor Initialization
    Product(int pId, float price, int quantity) {
        this.pId = pId;
        this.price = price;
        this.quantity = quantity;
    }

//    Method to calculate the sales tax
    @Override
    public void calcTax() {
        calTax = (salesTaxPercentage * price) / 100;
        System.out.println("Sales Tax for the Product Id " + pId + " is: " + calTax);
    }
}
class Employee implements Taxable {

//    Variable declaration
    int empId;
    String name;
    float salary;
    float calTax;

//    Constructor Initialization
    Employee(int empId, String name, float salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }
//    Method to calculate IncomeTax
    @Override
    public void calcTax() {
        calTax = (incomeTaxPercentage * salary) / 100;
        System.out.println("Income Tax For The Employee ID " + empId + " is: " + calTax);
    }
}

class Main   {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pId;
        float price;
        int qty;
        System.out.println("Enter the PID, Price, Quantity of the Product:");
        pId = sc.nextInt();
        price = sc.nextFloat();
        qty = sc.nextInt();
        Taxable product = new Product(pId, price, qty);
        product.calcTax();
        System.out.println();
        System.out.println();
        System.out.println();
        int empId;
        String name;
        float salary;
        System.out.println("Enter the Employee id, Name, Salary");
        empId = sc.nextInt();
        name = sc.next();
        salary = sc.nextFloat();
        Taxable employee = new Employee(empId, name, salary);
        employee.calcTax();
    }
}