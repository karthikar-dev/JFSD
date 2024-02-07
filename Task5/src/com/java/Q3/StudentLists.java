/*
     You are a teacher in school In your class there are 10 students, you have decided to give special gifts to
     those students whose names start with "A". You are asked to separate those students with help of a java program
        Requirement:
        Use List interface to store the student name
        Use a lambda expression and the Stream API to filter the students
*/

package com.java.Q3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLists {
    public static void main(String[] args) {
        // List Interface to store the students name
        List<String> students = Arrays.asList("Ayla", "Bella", "Ray", "Casper", "Amaya",
                "", "Zion", "Texen", "Kristen", "Aspen");
        System.out.print("\nList of students: " + students);

        //  Filtering the student using Lambda expression and stream api
        Stream<String> stream = students.stream().filter(student -> student.startsWith("A"));
        System.out.print("\n \nThe Filtered names that starts with A are: ");
        System.out.println(stream.collect(Collectors.toList())); // Print the filtered result

    }
}