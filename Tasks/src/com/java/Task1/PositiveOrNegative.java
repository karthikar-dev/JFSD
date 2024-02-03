package com.java.Task1;

import java.util.Scanner;
public class PositiveOrNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //    Input from user for number
        int num = sc.nextInt();

        // Using the if else condition to display the if positive or negative
        if (num >= 0) { // if number is greater than or equal to zero then its positive else negative
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }

    }
}