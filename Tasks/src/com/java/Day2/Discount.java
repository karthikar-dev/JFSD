package com.java.Day2;

import java.util.Scanner;

public class Discount {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
    //  Input from user
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
