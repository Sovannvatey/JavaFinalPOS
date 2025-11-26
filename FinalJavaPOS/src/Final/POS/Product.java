package Final.POS;

public abstract class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private double discountPercentage;

    public Product(String id, String name, double price, int quantity, double discountPercentage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discountPercentage = discountPercentage;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    // Setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Abstract method for polymorphism
    public abstract String getCategory();

    // Calculate price after discount
    public double getPriceAfterDiscount() {
        return price - (price * discountPercentage / 100);
    }

    // Decrease quantity when sold
    public void decreaseQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        }
    }
}
