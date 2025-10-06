//Import Spring Web annotations and utilities
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.*;

@RestController//Mars this class as a REST controller
@RequestMapping("/shop")// Base URL
public class ShoppingCartController {

    // Store carts in memory
    private final Map<String, Cart> carts = new HashMap<>();

    @PostMapping("/addItem")
    public String addItem(
            @RequestParam("cartId") String cartId,
            @RequestParam("itemName") String itemName,
            @RequestParam("price") BigDecimal price,
            @RequestParam("quantity") int quantity) {

        // Get or create cart
        Cart cart = carts.computeIfAbsent(cartId, id -> new Cart());

        // Add or update item
        cart.addItem(new CartItem(itemName, price, quantity));

        //Calculate the updated total of the cart
        BigDecimal total = cart.calculateTotal();
        return String.format("Item added. Total: %s", total);
    }

    @GetMapping("/getTotal")
    public String getTotal(@RequestParam("cartId") String cartId) {
        //Fetch cart from the in-memory store
        Cart cart = carts.get(cartId);

        //Handle case where cart does not exist
        if (cart == null) {
            return "Cart not found";
        }
        //Return total value of the cart 
        return "Total: " + cart.calculateTotal();
    }
}
