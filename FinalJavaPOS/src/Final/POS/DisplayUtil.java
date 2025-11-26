package Final.POS;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.Table;
import java.util.List;

public class DisplayUtil {
    
    public static void displayProducts(List<Product> products, int startIndex, int endIndex) {
        Table table = new Table(6, BorderStyle.DESIGN_PAPYRUS);
        
        // Add headers
        table.addCell("ID");
        table.addCell("Product Name");
        table.addCell("Category");
        table.addCell("Price");
        table.addCell("Discount %");
        table.addCell("Quantity");
        
        // Add product rows
        for (int i = startIndex; i < endIndex && i < products.size(); i++) {
            Product p = products.get(i);
            table.addCell(p.getId());
            table.addCell(p.getName());
            table.addCell(p.getCategory());
            table.addCell(String.format("$%.2f", p.getPrice()));
            table.addCell(String.format("%.1f%%", p.getDiscountPercentage()));
            table.addCell(String.valueOf(p.getQuantity()));
        }
        
        System.out.println("\n" + table.render());
        System.out.println("Showing products " + (startIndex + 1) + " to " + 
                          Math.min(endIndex, products.size()) + " of " + products.size());
    }
    
    public static void displayCart(List<CartItem> items) {
        if (items.isEmpty()) {
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║     Your cart is empty!            ║");
            System.out.println("╚════════════════════════════════════╝");
            return;
        }
        
        Table table = new Table(6, BorderStyle.DESIGN_PAPYRUS);
        
        // Add headers
        table.addCell("ID");
        table.addCell("Product Name");
        table.addCell("Price");
        table.addCell("Discount %");
        table.addCell("Qty");
        table.addCell("Total");
        
        // Add cart items
        for (CartItem item : items) {
            Product p = item.getProduct();
            table.addCell(p.getId());
            table.addCell(p.getName());
            table.addCell(String.format("$%.2f", p.getPrice()));
            table.addCell(String.format("%.1f%%", p.getDiscountPercentage()));
            table.addCell(String.valueOf(item.getQuantity()));
            table.addCell(String.format("$%.2f", item.getTotalPrice()));
        }
        
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║           SHOPPING CART            ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println(table.render());
    }
    
    public static void displayReceipt(Cart cart, Inventory inventory) {
        if (cart.isEmpty()) {
            System.out.println("\nCannot generate receipt. Cart is empty!");
            return;
        }
        
        Table table = new Table(5, BorderStyle.DESIGN_PAPYRUS);
        
        // Add headers
        table.addCell("ID");
        table.addCell("Product Name");
        table.addCell("Qty");
        table.addCell("Unit Price");
        table.addCell("Total");
        
        // Add items
        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            table.addCell(p.getId());
            table.addCell(p.getName());
            table.addCell(String.valueOf(item.getQuantity()));
            table.addCell(String.format("$%.2f", p.getPriceAfterDiscount()));
            table.addCell(String.format("$%.2f", item.getTotalPrice()));
        }
        
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║                    RECEIPT                     ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║            Tech Store POS System               ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println(table.render());
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.printf("║ Subtotal:                           $%9.2f ║%n", cart.getSubtotal());
        System.out.printf("║ Tax (%.1f%%):                          $%9.2f ║%n", cart.getTaxRate(), cart.getTax());
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.printf("║ TOTAL:                              $%9.2f ║%n", cart.getTotal());
        System.out.println("╚════════════════════════════════════════════════╝");
        
        // Update inventory
        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            p.decreaseQuantity(item.getQuantity());
            inventory.updateProductQuantity(p.getId(), p.getQuantity());
        }
        
        System.out.println("\n✓ Inventory updated successfully!");
        cart.clear();
        System.out.println("✓ Cart cleared!");
    }
    
    public static void displayMenu() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║      TECH STORE POS SYSTEM         ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ 1. Display All Products            ║");
        System.out.println("║ 2. Add Item to Cart                ║");
        System.out.println("║ 3. View Cart                       ║");
        System.out.println("║ 4. Calculate Total                 ║");
        System.out.println("║ 5. Set Tax Rate                    ║");
        System.out.println("║ 6. Generate Receipt & Checkout     ║");
        System.out.println("║ 7. Exit                            ║");
        System.out.println("╚════════════════════════════════════╝");
    }
}
