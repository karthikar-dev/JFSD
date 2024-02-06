/*
    Create a stack data structure to store Integers Create some methods for following functionalities.
    a. Include functions for pushing elements onto the stack.
    b. popping elements from the stack.
*/

package com.java.Q5;

import java.util.Scanner;
import java.util.Stack;

public class StackOperations {
    private static final Stack<Integer> stack = new Stack<>(); // Global stack variable Creation
    

    // Main Method
    public static void main(String[] args) {
        StackOperations op = new StackOperations(); // stack operation class object creation
        op.stackOperations(); // stack operations method initialized
    }

    public void stackOperations() {
        Scanner sc = new Scanner(System.in);
    //  Menu to display the options for stack operation
        System.out.println("\nPlease select the operation to be performed in a stack");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Peek");
        System.out.println("4. Empty");
        System.out.println("5. Exit the Menu\n");

        int option = sc.nextInt(); // Reads input from the user
        switch (option) {
            case 1 -> { // Java 9 - 17 lambda expression for switch
                        System.out.println("Enter the size of the stack");
                        int count = sc.nextInt();
                        System.out.println("Enter the numbers to be pushed into the stack");
                        for (int i = 0; i < count; i++) {
                            int num = sc.nextInt();
                            stack.push(num); // Pushes each number inside stack
                        }
                        System.out.println("\nThe values in the stack are");
                        displayResult(stack); // display the result
                        stackOperations(); // callback to show the option again
                    }
            case 2 -> {
                System.out.println("\nRemoving the element from the stack");
                stack.pop(); // Remove the last element in the stack
                System.out.println("\nValues after removing the element");
                displayResult(stack);
                stackOperations();
            }
            case 3 -> {
                System.out.println("\nShow the top most element in the stack");
                System.out.println(stack.peek()); // display the top most element in the stack
                System.out.println("\nThe values in the stack");
                displayResult(stack);
                stackOperations();
            }
            case 4 -> {
                System.out.println("\nCheck if stack is empty");
                System.out.println(stack.empty()); // Checks if the stack is empty and return a boolean value
                System.out.println("\nThe values in the stack");
                displayResult(stack);
                stackOperations();
            }
            case 5 -> {
                System.out.println("Thank you using the Stack!! Visit again soon.");
            }
            default -> {
                System.out.println("Option not available. Please try again");
                System.out.println();
                System.out.println();
                stackOperations();
            }
        }

    }

    public void displayResult(Stack<Integer> stack) { // Displays the result as per the option selected
        System.out.println(stack);
        System.out.println();
    }
}
