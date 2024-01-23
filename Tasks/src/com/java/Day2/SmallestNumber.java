package com.java.Day2;

import java.util.Scanner;

public class SmallestNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int small;
        if (num1 <= num2 && num1 <= num3)
            small = num1;
        else if (num2 <= num1 && num2 <= num3)
            small = num2;
        else
            small = num3;
        System.out.println("Smallest Number:" + small);
    }
}
