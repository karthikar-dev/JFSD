/*
    Write a program using map() method, to convert a list of Strings into uppercase.
    If the given List is: Stream names = Stream.of("abc", "d", "ef");
*/

package com.java.Q1;

import java.util.List;
import java.util.stream.Stream;

public class UpperCaseStrings {
    public static void main(String[] args) {
        Stream < String > names = Stream.of("aBc", "d", "ef"); // Given list
        List < String > upperCase = names.map(String::toUpperCase).toList();
        System.out.println("Input in Stream is: [aBc, d, ef]");
        System.out.println("Output in Uppercase is: " + upperCase); // Print the strings in uppercase using map and toUppercase method
    }
}
