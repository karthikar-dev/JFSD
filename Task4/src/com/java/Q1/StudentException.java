/*
    Ramesh is developing a student management system for a university. In this system, you have a Student class
    to represent student information. You are asked to help Ramesh to handle exception which can be occurred
    into program according to following Scenarios:
    => class Student with attributes roll no, name, age and course. Initialize values through parameterized constructor.
    => If the age of the student is not between 15 and 21 then generate a user-defined exception
        "Age Not WithinRangeException".
    => If a name contains numbers or special symbols, raise exception. "NameNot ValidException".
    Define the two exception classes.
 */

package com.java.Q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Age Not Within the Range Exception class that extends exception
class AgeNotWithInRangeException extends Exception {

    //    Parameterized constructor throwing user-defined exception message
    public AgeNotWithInRangeException(String message) {
        super(message);
    }
}

// Name is not Valid Exception class that extends exception
class NameNotValidException extends Exception {

    //    Parameterized constructor throwing user-defined exception message
    public NameNotValidException(String message) {
        super(message);
    }
}

class Student {
    int rollNo, age;
    String name, course;

    //    Parameterized constructor for initializing attributes
    Student(int s_rno, String s_name, int s_age, String s_course) {
        rollNo = s_rno;
        name = s_name;
        age = s_age;
        course = s_course;
        /* **************** Name Valid or Not Exception check ********************* */
        try {
            //  looping through the characters in the name to check if it is valid or not
            for (int i = 0; i < name.length(); i++)
                if (Character.isDigit(name.charAt(i)) || (name.charAt(i) < 'A' || name.charAt(i) > 'Z' && name.charAt(i) < 'a' || name.charAt(i) > 'z'))
                    throw new NameNotValidException("Name Not Valid Exception"); // throws exception if name not valid
        } catch (NameNotValidException e1) { // catches exception and prints the message
            System.err.println(e1.getMessage());
        } finally {
            System.out.println();
        }
        /* **************** Age Valid or Not Exception check ********************* */
        //  checking if age is valid or not
        try {
            if (age < 15 || age > 21) // throws exception if age is less than 15 or greater than 21
                throw new AgeNotWithInRangeException("Age Not Within Range Exception...");
        } catch (AgeNotWithInRangeException e2) { // catches exception and prints the message
            System.err.println(e2.getMessage());
        } finally {
            System.out.println();
        }

    }

    //    Method to display the output
    public void display() {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%10s %30s %10s %30s", "Roll No", "Name", "Age", "Course");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.format("%10s %30s %10s %30s", rollNo, name, age, course);
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------");
    }
}

public class StudentException {
    public static void main(String[] args) throws IOException {

    /* BufferedReader cant read the InputStream directly. So, we need to use an adapter like
InputStreamReader to convert bytes to characters format. */

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.print("Enter the Roll No : ");
        //        Reads the input from the user
        int rollNo = Integer.parseInt(in.readLine()); // Reads a line of text

        System.out.print("Enter the Name : ");
        String name = in.readLine();

        System.out.print("Enter the Age : ");
        int age = Integer.parseInt(in.readLine());

        System.out.print("Enter the Course : ");
        String course = in.readLine();

        // Object creation for student class
        Student s1 = new Student(rollNo, name, age, course);

        //  Display method call
        s1.display();
    }
}