package com.java;

import java.util.Scanner;

public class SmallestNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        User input
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int small;
//        If else condition to check the smallest number
        if (num1 <= num2 && num1 <= num3)
            small = num1; // if the number 1 is less that 2 and 3 then the small value is assigned as number 1
        else if (num2 <= num1 && num2 <= num3)
            small = num2; // if the number 2 is less that 2 and 3 then the small value is assigned as number 2
        else
            small = num3;  // if both condition fail number 3 will be set as small
        System.out.println("Smallest Number:" + small);
    }
}
