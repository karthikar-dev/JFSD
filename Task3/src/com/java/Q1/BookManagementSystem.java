/*
    1.Design a Java program that uses OOP principles to model the Book Create two classes: Book and Library.
    The Book class should have attributes such as bookID, title, author, and is Available.
    The Library class should include an array to store book objects.
    2. Provide methods to add book, remove book search book (using id)and display books. Write a Java program that
    demonstrates the use of these classes and methods by allowing the user to interact with the library system.

 */
package com.java.Q1;

import java.util.Scanner;

public class BookManagementSystem {

    //    Method to Display Menu
    public static void displayMenu(Library library, Scanner sc) {
        System.out.println("Please select one option from the menu");
        System.out.println("1. View All Books");
        System.out.println("2. Add New Book");
        System.out.println("3. Remove a Book using ID");
        System.out.println("4. Search a Book using ID");
        System.out.println("5. Exit");
        int option = sc.nextInt();
        switch (option) { // Switch case to select an option from the displayed Menu
            case 1:
                library.displayAllBooks(); // Call to display all books
                System.out.println();
                System.out.println();
                displayMenu(library, sc);
                break;
            case 2:
                //   User inputs for adding a book
                System.out.println("Enter BookID of the Book:");
                int bookID = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter Book Title:");
                String title = sc.nextLine();

                System.out.println("Enter Author Name:");
                String author = sc.nextLine();

                System.out.println("Available:");
                String isAvailable = sc.nextLine();
                //    Object Initialization for each entry
                Book book = new Book(bookID, title, author, isAvailable);
                //    Setting values for book attributes
                book.setBookID(bookID);
                book.setTitle(title);
                book.setAuthor(author);
                book.setIsAvailable(isAvailable);
                library.addBook(book);
                System.out.println();
                System.out.println();
                library.displayAllBooks();
                System.out.println();
                System.out.println();
                displayMenu(library, sc);
                break;
            case 3:
                System.out.println("Enter the book id your want to remove");
                int id = sc.nextInt();
                library.removeBook(id); // Call for removing a book by passing id as parameter
                System.out.println();
                System.out.println();
                library.displayAllBooks();
                System.out.println();
                System.out.println();
                displayMenu(library, sc);
                break;
            case 4:
                System.out.println("Enter the book id your want to search");
                int bookId = sc.nextInt();
                library.searchByID(bookId); // Searching a book by passing id as parameter
                System.out.println();
                System.out.println();
                displayMenu(library, sc);
                break;
            case 5:
                System.out.println("Thank you using the Library!! Visit again soon.");
                break;
            default:
                System.out.println("Option not available. Please try again");
                System.out.println();
                System.out.println();
                displayMenu(library, sc);
                break;
        }
    }
    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        // Add new books
        library.addBook(new Book(1001, "Learn Java", "John Doe", "Y"));
        library.addBook(new Book(1002, "Learn Advanced Java", "John Clare", "Y"));
        library.addBook(new Book(1003, "Learn Python", "Mc Laren", "N"));
        library.addBook(new Book(1004, "Learn Data structures", "Amit Shah", "N"));
        library.addBook(new Book(1005, "Learn C++", "David Joe", "Y"));

        displayMenu(library, sc); // To display the menu

    }
}