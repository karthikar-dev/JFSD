/*
    Write a Java program that takes the purchase amount as input and calculates the final payable amount
    after applying the discount.
    1. If the purchase amount is less than 500, no discount is applied.
    2. If the purchase amount is between 500 and 1000, a 10% discount is applied.
    3. If the purchase amount is greater than 1000 a 20% discount is applied.
 */

package com.java.Q5;
import java.util.Scanner;

public class Discount {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
    //  Input from user
        System.out.println("Enter the amount to find the discount");
        float amount = sc.nextFloat();
        float price = 0;

    //  Discount Calculation
        if (amount > 1000)
            price = (amount*20)/100;
        else if (amount >= 500)
            price = (amount*10)/100;
        else
            price = amount;

    //  Print the result
        System.out.println(price);
    }
}
