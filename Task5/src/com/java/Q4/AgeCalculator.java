/*
    Rajesh has been given a task to create an app which takes the user's birthdate as input and calculates their
    age java.time.LocalDate class. you have to help him to build this app using the
    Input:
    Enter your birthdate (yyyy-mm-dd): 1990-05-15
    Output:
    Your age is: 33 years, 4 months, and 13 days.
*/

package com.java.Q4;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AgeCalculator {

    // Method to calculate the age
    public void calculateAge(LocalDate dob) {

        // Creating an instance of the LocalDate class and invoking the now() method
        // now() method obtains the current date from the system clock in the default time zone
        LocalDate currentDate = LocalDate.now();

        //calculates the amount of time between two dates and returns the years
        Period p = Period.between(dob, currentDate);

        // Prints the age calculated in Year Months and Days
        System.out.println("Your age is: " + p.getYears() + " years, " + p.getMonths() +
                " months and " + p.getDays());
    }

    public static void main(String[] args) {
        System.out.print("Enter your birthdate (YYYY-MM-dd): ");
        Scanner sc = new Scanner(System.in);

        // Reads the date of birth from the user
        String input = sc.nextLine();
        sc.close();

        // Create an object of class AgeCalculator
        AgeCalculator age = new AgeCalculator();

        // the parse() method obtains an instance of LocalDate from a text string such as 1992-08-11
        LocalDate dob = LocalDate.parse(input);

        //  Method call for Age Calculation
        age.calculateAge(dob);
    }

}