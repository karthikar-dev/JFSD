/*
    Create a class Person with properties (name and age) with following features.
    a. Default age of person should be 18;
    b. A person object can be initialized with name and age;
    c. Method to display name and age of person
 */

package com.java.Q1;

public class Person {
    //   Variable Declaration
    protected String name;
    protected int age = 18;

    //   Default Constructor
    public Person() {
    }

    // Parameterized Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //    Main Function
    public static void main(String[] args) {
        //        Object creation for Person class
        Person person = new Person();
        //        Initialization
        person.name = "Mark";
        person.age = 20;
        //        Calling method using object
        person.display();
    }

    //    Method to display the name and age
    private void display() {
        System.out.println(this.name);
        System.out.println(this.age);
    }
}
