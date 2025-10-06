// Package declaration and import dependencies
package com.example.shop;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


//Represents a shopping cart
class Cart {
    // Map to store items in the cart
    private final Map<String, CartItem> items = new HashMap<>();
    /*
    Adds item to a cart
    If an item already exists with the same name already , it increases quantity
    Otherwise , it adds the new item to the cart
    */
    public void addItem(CartItem item) {
		if (items.containsKey(item.getName())) {
            // If the item already exists, increase the quantity of the existing item
			items.get(item.getName()).increaseQuantity(item.getQuantity());
		} else  {
                // If the item does not exist, put it in the map
				items.put(item.getName(), item);
				}

    }
    /*
    Calculates the total price of items in cart
    */

    public BigDecimal calculateTotal() {
		
		BigDecimal total = BigDecimal.ZERO; //Initialize the total to zero
        
        //Iterate over all items in the cart and sum up total price
        for(CartItem item : items.values()){
				total = total.add(item.getTotal());
				}
		return total; //Return the calculated total
    }
}

