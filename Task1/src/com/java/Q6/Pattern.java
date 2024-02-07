/*
    Write a java program to print bellowed pattern
    55555
    54444
    54333
    54322
    54321
 */

package com.java.Q6;

public class Pattern {
    public static void main(String[] args) {

    //  Looping to display the pattern
        for (int i=0; i<5; i++) {
            for (int j=5; j>=1; j--) {
                if ((i+j) > 5)
                    System.out.print(j + " ");
                else
                    System.out.print((5 - i)+ " ");
            }
            System.out.println();
        }

    }
}
