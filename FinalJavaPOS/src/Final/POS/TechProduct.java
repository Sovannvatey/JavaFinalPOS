package Final.POS;

public class TechProduct extends Product {
    private String category;

    public TechProduct(String id, String name, double price, int quantity, double discountPercentage, String category) {
        super(id, name, price, quantity, discountPercentage);
        this.category = category;
    }

    @Override
    public String getCategory() {
        return category;
    }
}


