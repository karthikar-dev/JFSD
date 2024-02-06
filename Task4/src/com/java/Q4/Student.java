/*
    Create a HashMap where keys are student names (strings) and values are their corresponding grades (integers).
    Create methods to add a new student, remove a student, and Display up a student's grade by name.
 */

package com.java.Q4;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Student {

    private final HashMap < String, Integer > students = new HashMap < > (); // Global declaration hashmap

    public Student() {
        students.put("Anish", 83); // Adding some predefined values to hashmap
        students.put("Akash", 70);
        students.put("Ragul", 90);
        students.put("Danish", 55);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student studentObj = new Student(); // Student class object creation
        studentObj.displayMenu(input);
    }

    // Method to display the menu
    public void displayMenu(Scanner sc) {
        // Options to perform the operation
        System.out.println("Please select the operations you want to perform");
        System.out.println("1. Add a student");
        System.out.println("2. Remove a student");
        System.out.println("3. Display Student Grade based on Name");
        System.out.println("4. Display all student");
        System.out.println("5. Exit");
        int op = sc.nextInt(); // reads user input
        switch (op) { // Switch to select the required operation
            case 1 -> addStudent(sc);
            case 2 -> removeStudent(sc);
            case 3 -> displayStudentBasedOnGrade(sc);
            case 4 -> displayAllStudents(sc);
            case 5 -> System.out.println("Thanks for using the HashMap!!! ");
            default -> {
                System.out.println("Option not Valid. Please try again!!! ");
                displayMenu(sc);
            }
        }

    }

    // Method to add a student
    public void addStudent(Scanner sc) {
        System.out.print("\nEnter the student name: ");
        String name = sc.next();
        System.out.print("Enter the student grade: ");
        int grade = sc.nextInt();
        students.put(name, grade);
        displayAllStudents(sc);
        displayMenu(sc);
    }

    // Method to remove a student
    public void removeStudent(Scanner sc) {
        System.out.print("\nEnter the name of the student to be removed: ");
        String name = sc.next();
        students.remove(name);
        displayAllStudents(sc);
        displayMenu(sc);
    }

    // Method to display a student grade based on the name
    public void displayStudentBasedOnGrade(Scanner sc) {
        System.out.print("\nEnter the name of the student to show the grade: ");
        String name = sc.next();
        for (HashMap.Entry < String, Integer > student: students.entrySet()) {
            if (student != null && Objects.equals(student.getKey(), name)) {
                System.out.println("\nStudent name: " + student.getKey());
                System.out.println("Grade: " + student.getValue());
                System.out.println();
            }
        }
        displayMenu(sc);
    }

    // Method to display all students
    public void displayAllStudents(Scanner sc) {
        System.out.println("\nDisplaying All the Students\n");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%30s %30s", "NAME", "GRADE");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        //iterates over the list
        for (HashMap.Entry < String, Integer > student: students.entrySet()) {
            if (student != null)
                System.out.format("%30s %30s", student.getKey(), student.getValue());
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------");
        displayMenu(sc);
    }

}