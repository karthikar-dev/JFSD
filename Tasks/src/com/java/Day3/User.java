package com.java.Day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    //    Main Function
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        User user = new User();
        System.out.println("Enter 5 Product details:");
        //        Getting user inputs on products and store it in arrayList
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int pid;
            double price;
            int qty;
            System.out.print("Product ID: ");
            pid = sc.nextInt();
            System.out.println("Product Price: ");
            price = sc.nextDouble();
            System.out.println("Product Quantity: ");
            qty = sc.nextInt();

            // Adding each product to the list
            products.add(new Product(pid, price, qty));
        }
        //     Methods calling
        user.highestPrice(products);
        user.priceOfAllProducts(products);
    }

    //    Method to find and display the highest price among the products
    public void highestPrice(List<Product> products) {
        double price = 0;
        for (Product p : products) { // for each loop to get the list of products
            double temp = p.price; // Assigning each price to temp for comparing
            if (temp > price) {  // comparing each price and assigning the highest to price
                price = temp;
            }
        }
        System.out.println("Highest Product price: " + price); // Display the highest
    }

    //    Display the total price of the products
    public void priceOfAllProducts(List<Product> products) {
        double totalPrice = 0;
        for (Product p : products) { // for each loop to get the list of products
            double price = p.price;
            int qty = p.quantity;
            totalPrice += price * qty; // multiply each price with quantity and add it to the total price
        }
        System.out.println("Overall Price of all Products: " + totalPrice);
    }
}
