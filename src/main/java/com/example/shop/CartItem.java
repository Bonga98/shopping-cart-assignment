import java.math.BigDecimal;
import java.util.*;

//Represents an item in the cart
class CartItem {
    private final String name;
    private final BigDecimal price;
    private int quantity;

    public CartItem(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public void increaseQuantity(int qty) {
        this.quantity += qty;
    }

    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public int getQuantity() { return quantity; }
}
