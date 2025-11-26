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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract String getCategory();

    public double getPriceAfterDiscount() {
        return price - (price * discountPercentage / 100);
    }

    public void decreaseQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        }
    }
}

