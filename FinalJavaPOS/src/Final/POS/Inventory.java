package Final.POS;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
        initializeProducts();
    }

    private void initializeProducts() {
        products.add(new TechProduct("001", "MacBook Pro 16\"", 2499.99, 15, 5.0, "Laptop"));
        products.add(new TechProduct("002", "Dell XPS 15", 1899.99, 20, 10.0, "Laptop"));
        products.add(new TechProduct("003", "HP Spectre x360", 1599.99, 18, 8.0, "Laptop"));
        products.add(new TechProduct("004", "Lenovo ThinkPad X1", 1799.99, 12, 7.0, "Laptop"));
        products.add(new TechProduct("005", "ASUS ROG Zephyrus", 2199.99, 10, 12.0, "Laptop"));
        products.add(new TechProduct("006", "iPhone 15 Pro Max", 1199.99, 30, 3.0, "Smartphone"));
        products.add(new TechProduct("007", "Samsung Galaxy S24 Ultra", 1099.99, 25, 5.0, "Smartphone"));
        products.add(new TechProduct("008", "Google Pixel 8 Pro", 899.99, 20, 8.0, "Smartphone"));
        products.add(new TechProduct("009", "OnePlus 12", 799.99, 22, 10.0, "Smartphone"));
        products.add(new TechProduct("010", "Xiaomi 14 Pro", 749.99, 28, 12.0, "Smartphone"));
        products.add(new TechProduct("011", "iPad Pro 12.9\"", 1099.99, 15, 6.0, "Tablet"));
        products.add(new TechProduct("012", "Samsung Galaxy Tab S9", 849.99, 18, 7.0, "Tablet"));
        products.add(new TechProduct("013", "Microsoft Surface Pro 9", 999.99, 12, 8.0, "Tablet"));
        products.add(new TechProduct("014", "Lenovo Tab P12", 599.99, 20, 15.0, "Tablet"));
        products.add(new TechProduct("015", "Amazon Fire HD 10", 149.99, 35, 20.0, "Tablet"));
        products.add(new TechProduct("016", "Sony WH-1000XM5", 399.99, 25, 10.0, "Headphones"));
        products.add(new TechProduct("017", "Apple AirPods Pro 2", 249.99, 40, 5.0, "Headphones"));
        products.add(new TechProduct("018", "Bose QuietComfort 45", 329.99, 22, 12.0, "Headphones"));
        products.add(new TechProduct("019", "Sennheiser Momentum 4", 379.99, 18, 8.0, "Headphones"));
        products.add(new TechProduct("020", "JBL Tune 760NC", 129.99, 30, 18.0, "Headphones"));
        products.add(new TechProduct("021", "Apple Watch Series 9", 429.99, 20, 4.0, "Smartwatch"));
        products.add(new TechProduct("022", "Samsung Galaxy Watch 6", 349.99, 25, 10.0, "Smartwatch"));
        products.add(new TechProduct("023", "Garmin Fenix 7", 699.99, 12, 5.0, "Smartwatch"));
        products.add(new TechProduct("024", "Fitbit Sense 2", 299.99, 28, 15.0, "Smartwatch"));
        products.add(new TechProduct("025", "Amazfit GTR 4", 199.99, 32, 20.0, "Smartwatch"));
        products.add(new TechProduct("026", "Logitech MX Master 3S", 99.99, 40, 8.0, "Mouse"));
        products.add(new TechProduct("027", "Razer DeathAdder V3", 79.99, 35, 12.0, "Mouse"));
        products.add(new TechProduct("028", "Corsair K95 RGB", 199.99, 18, 10.0, "Keyboard"));
        products.add(new TechProduct("029", "Keychron K8 Pro", 109.99, 25, 15.0, "Keyboard"));
        products.add(new TechProduct("030", "SteelSeries Apex Pro", 179.99, 20, 8.0, "Keyboard"));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product findProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void updateProductQuantity(String id, int newQuantity) {
        Product product = findProductById(id);
        if (product != null) {
            product.setQuantity(newQuantity);
        }
    }
}

