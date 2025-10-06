import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/shop")
public class ShoppingCartController {

    // Store carts in memory (stub for demo purposes)
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

        BigDecimal total = cart.calculateTotal();
        return String.format("Item added. Total: %s", total);
    }

    @GetMapping("/getTotal")
    public String getTotal(@RequestParam("cartId") String cartId) {
        Cart cart = carts.get(cartId);

        if (cart == null) {
            return "Cart not found";
        }

        return "Total: " + cart.calculateTotal();
    }
}
