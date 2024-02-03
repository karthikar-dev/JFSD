package com.java.Q1;

import java.util.ArrayList;
import java.util.List;

public class Library {

    //    Variable declaration
    private final List < Book > books = new ArrayList < > ();
    int count = 0;

    public Library() { // Constructor
        super();
    }

    //    Method to add a book to the library
    public void addBook(Book book) {
        for (Book value: books) {
            if (value != null) {
                //    Check for book if existing using ID and Title
                if (this.checkExistingBooks(book, value) == 0)
                    return;
            }
        }
        if (count < 5) {
            books.add(book); // Add is the array is empty
            count++;
        } else {
            System.out.println("No Space to Add More Books."); // Show if the array is full
        }
    }

    //    To check if the book already exists
    public int checkExistingBooks(Book b1, Book b2) {

        // If Book Title matches
        if (b1.getTitle().equalsIgnoreCase(b2.getTitle())) {
            System.out.println("Book of this Name Already Exists."); // Print book exists
            return 0;
        }

        // If Book ID matches
        if (b1.getBookID() == b2.getBookID()) {
            System.out.println("Book of this ID No Already Exists.");  // Print book exists
            return 0;
        }
        return 1;
    }
    // Method to remove a book from the library
    public void removeBook(int bookID) {
        //        Filtering through the books to check if the book id matches
        books.stream().filter(book -> book.getBookID() == bookID).forEach(book -> {
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.printf("%10s %30s %30s %10s", "S.NO", "NAME", "AUTHOR", "AVAILABLE");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.format("%10s %30s %30s %10s", book.getBookID(), book.getTitle(), book.getAuthor(), book.getIsAvailable());
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------");
        });
        //        Remove if the book id matches in the list of books
        books.removeIf(book -> book.getBookID() == bookID);
        count--;
        System.out.println("The Above book is removed");

    }

    //    Method to display all books in the library
    public void displayAllBooks() {
        System.out.println("Displaying All the Books\n");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("%10s %30s %30s %10s", "S.NO", "NAME", "AUTHOR", "AVAILABLE");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        //iterates over the list
        for (Book book: books) {
            if (book != null)
                System.out.format("%10s %30s %30s %10s", book.getBookID(), book.getTitle(), book.getAuthor(), book.getIsAvailable());
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------------------------------");

    }

    //    Method to search a book
    public void searchByID(int id) {
        //        filter the book by using stream.filter to check if the id matches
        books.stream().filter(book -> book.getBookID() == id).forEach(book -> {
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.printf("%10s %30s %30s %10s", "S.NO", "NAME", "AUTHOR", "AVAILABLE");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.format("%10s %30s %30s %10s", book.getBookID(), book.getTitle(), book.getAuthor(), book.getIsAvailable());
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------");
        });
    }

}