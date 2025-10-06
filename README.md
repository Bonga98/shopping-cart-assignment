Shopping Cart Assignment
--------------------------------------------------------------------------------
This repository contains a refactored Java implementation of a basic e-commerce shopping cart, created as part of a technical assessment. The focus is on improving readability, maintainability, and correctness, while preserving the original business functionality (adding items to a cart and calculating totals).

Approach:
-----------------------------------

Separation of Concerns:

ShoppingCartController handles REST endpoints only.

Cart handles business logic (add/update items, calculate totals).

CartItem represents individual items in the cart.

Implementation Choices
------------------------------

REST Controller: Exposes simple endpoints (/addItem, /getTotal) using Spring annotations for clean API design.

In-memory Map for carts: Efficiently stores and retrieves carts by cartId; simple and fast for demonstration.

computeIfAbsent: Automatically creates a cart if it doesn’t exist

CartItem design: Immutable name and price; mutable quantity  for easy quantity updates.

Cart design: Aggregates items, updates quantities, and calculates totals with BigDecimal for financial accuracy.

Separation of concerns: Clear division between ShoppingCartController, Cart, and CartItem.

Maintainable and scalable: Modular structure allows easy extension, testing, and future integration.

Replaced unsafe double with BigDecimal for monetary calculations.

I kept HashMap to store carts and items because it provides fast O(1) lookups and updates, 
which is ideal for quickly adding items, updating quantities, and calculating totals

Removed duplicate total-calculation logic by adding Cart.calculateTotal().

