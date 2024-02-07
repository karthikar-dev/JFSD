/*
    Write a program to check whether the Strings in the List are empty or not and print the list having non-empty strings.
    If the given List is: List strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
*/

package com.java.Q2;

import java.util.Arrays;
import java.util.List;

public class NotEmptyStringsList {
    public static void main(String[] args) {
        List < String > strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl"); // Given Input
        // filters the empty string and assign it to a new list
        List < String > list = strings.stream().filter(item -> !item.isEmpty()).toList();
        // Print the list
        System.out.println("\nInput List is: " + strings + " \n");
        System.out.println("Filtered List is: " + list);
    }
}