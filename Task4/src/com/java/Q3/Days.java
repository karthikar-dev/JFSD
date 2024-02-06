/**
 * Store name of weekdays in an array (starting from "Sunday" at 0 index).
 * Ask day position from user and print day name. Handle array index out of bound exception and give proper message
 * if user enters day index outside range (0-6).
 **/

package com.java.Q3;

import java.util.Scanner;

public class Days {

    //    Main class method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of the Day 0 for Sunday till 6 for Saturday");

        //  Reads the user input
        int input = sc.nextInt();
        String[] days = {
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        };
        // try catch block to check the number is valid or not
        try {
            System.out.println("The Selected day is : " + days[input]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage()); // Catches exception if the number is greater the array index.
            //   Prints the user defined exception for array index out of bound
            System.err.println("The entered range is not between 0 and 6. Please enter within the given range");
        }
    }
}