import java.math.BigDecimal;
import java.util.

//Represents a shopping cart
class Cart {
    private final Map<String, CartItem> items = new HashMap<>();

    public void addItem(CartItem item) {
        items.merge(item.getName(),
                item,
                (existing, newItem) -> {
                    existing.increaseQuantity(newItem.getQuantity());
                    return existing;
                });
    }

    public BigDecimal calculateTotal() {
        return items.values().stream()
                .map(CartItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}