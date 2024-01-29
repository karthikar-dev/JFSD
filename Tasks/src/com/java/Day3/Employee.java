package com.java.Day3;

import java.util.Scanner;

public class Employee extends Person {
    //    Variable Declaration
    private final String employeeID;
    private final double salary;

    //  Parameterized Constructor
    public Employee(String name, String employeeID, int age, double salary) {
        super(name, age);
        this.employeeID = employeeID;
        this.salary = salary;
    }

    //    Main Method
    public static void main(String[] args) {
        // Getting inputs from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of employees");
        int count = sc.nextInt();
        Employee[] emp = new Employee[count];
        //        Looping the employee count to fetch details.
        for (int i = 0; i < count; i++) {
            System.out.println("Enter the employee details as Name, Employee id, Age, Salary");
            String emp_name = sc.nextLine();
            String emp_id = sc.nextLine();
            int emp_age = sc.nextInt();
            double emp_salary = sc.nextDouble();
            emp[i] = new Employee(emp_name, emp_id, emp_age, emp_salary);
        }
        // Displaying Employee Details
        for (int j = 0; j < count; j++) {
            emp[j].displayEmployeeDetails();
        }

    }

    //  Displaying employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee Details are");
        System.out.println("Employee ID: " + this.employeeID);
        System.out.println("Employee Name: " + this.name);
        System.out.println("Employee Age: " + this.age);
        System.out.println("Employee Salary: " + this.salary);
    }

}