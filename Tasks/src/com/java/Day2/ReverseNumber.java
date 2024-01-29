package com.java.Day2;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //  User input for number
        int num = sc.nextInt();
        int rev = 0;
//        while loop to iterate every number
        while(num != 0) {
            int remainder = num % 10; // Get the remainder of the number
            rev = rev * 10 + remainder; // Remainder added to the reverse*10
            num /= 10;  // number is divided by the 10 and the quotient is added to number to keep the loop iterating
        }

        System.out.println("Reversed Number: " + rev);
    }
}
