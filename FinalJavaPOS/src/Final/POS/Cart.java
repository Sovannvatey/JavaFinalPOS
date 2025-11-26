package Final.POS;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;
    private double taxRate;

    public Cart() {
        items = new ArrayList<>();
        taxRate = 10.0; // 10% tax by default
    }

    public void addItem(Product product, int quantity) {
        // Check if product already exists in cart
        for (CartItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.addQuantity(quantity);
                return;
            }
        }
        // If not found, add new item
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    public double getTax() {
        return getSubtotal() * taxRate / 100;
    }

    public double getTotal() {
        return getSubtotal() + getTax();
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void clear() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
