/*
    Create a class Voter(voterId, name, age) with  parameterized constructor.
    The parameterized constructor should throw a checked exception if age is less than 18.
    The message of exception is "invalid age for voter"
*/

package com.java.Q2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class AgeException extends Exception {
    public AgeException(String str) {
        super(str); // Call super exception class constructor.
    }
}

public class Voter {
    int age;
    String name;
    String voterId;

    // Declare a parameterized constructor with a parameter str of type string.
    public Voter(String name, int age, String voterId) {
        this.age = age;
        this.name = name;
        this.voterId = voterId;

        //  Try catch block to check and catch the exception if it is an invalid age for the user
        try {
            if (age < 18) {
                throw new AgeException("Invalid age for Voter");
            }
        } catch (AgeException ex) { // Catches the Age Exception and displays the message
            System.err.println(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e); // Catches the run time exception
        } finally {
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();

        System.out.print("Enter the Name : ");
        String name = in.readLine(); // Reads a line of text

        System.out.print("Enter the Age : ");
        int age = Integer.parseInt(in.readLine());

        System.out.print("Enter the Voter ID : ");
        String voterId = in.readLine();
        Voter voter = new Voter(name, age, voterId); // Object creation for the Voter Class

        voter.display();  // Method call to display the output
    }

    // Method to print the output
    public void display() {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%30s %10s %30s", "Name", "Age", "Voter ID");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.format("%30s %10s %30s", name, age, voterId);
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------");
    }
}

