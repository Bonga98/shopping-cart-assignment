Shopping Cart Assignment
--------------------------------------------------------------------------------
This repository contains a refactored Java implementation of a basic e-commerce shopping cart, created as part of a technical assessment. The focus is on improving readability, maintainability, and correctness, while preserving the original business functionality (adding items to a cart and calculating totals).

Approach:
-----------------------------------

Separation of Concerns:

ShoppingCartController handles REST endpoints only.

Cart handles business logic (add/update items, calculate totals).

CartItem represents individual items in the cart.

Improved Data Handling:
------------------------------

Replaced unsafe double with BigDecimal for monetary calculations.

I kept HashMap to store carts and items because it provides fast O(1) lookups and updates, 
which is ideal for quickly adding items, updating quantities, and calculating totals

Cleaner Code:

Removed duplicate total-calculation logic by adding Cart.calculateTotal().

Each class is in its own file to demonstrate separation and maintainability.
