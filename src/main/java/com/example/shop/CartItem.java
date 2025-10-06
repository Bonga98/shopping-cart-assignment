package com.example.shop;
import java.math.BigDecimal;
import java.util.*;

//Represents an item in the cart
class CartItem {
    private final String name;
    private final BigDecimal price;
    private int quantity;
    //Constructor to create new CartItem
    public CartItem(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    //Method to calculate the total price
    public BigDecimal getTotal() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
    //Method to increase the quatity of the item
    public void increaseQuantity(int qty) {
        this.quantity += qty; //Update the quantity
    }

    public String getName() { return name; } // Getter for item name
    public BigDecimal getPrice() { return price; } //Getter for item price
    public int getQuantity() { return quantity; } // Getter for item quantity
}


