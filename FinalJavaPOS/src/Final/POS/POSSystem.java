package Final.POS;

public class POSSystem {
    private Inventory inventory;
    private Cart cart;
    private Scanner scanner;

    public POSSystem() {
        inventory = new Inventory();
        cart = new Cart();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║   Welcome to Tech Store POS System!            ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        while (running) {
            DisplayUtil.displayMenu();
            System.out.print("\nEnter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        displayAllProducts();
                        break;
                    case 2:
                        addItemToCart();
                        break;
                    case 3:
                        viewCart();
                        break;
                    case 4:
                        calculateTotal();
                        break;
                    case 5:
                        setTaxRate();
                        break;
                    case 6:
                        generateReceipt();
                        break;
                    case 7:
                        running = false;
                        System.out.println("\n╔════════════════════════════════════╗");
                        System.out.println("║   Thank you for using POS System!  ║");
                        System.out.println("╚════════════════════════════════════╝");
                        break;
                    default:
                        System.out.println("\n✗ Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("\n✗ Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        scanner.close();
    }

    private void displayAllProducts() {
        List<Product> products = inventory.getAllProducts();
        int currentIndex = 0;
        int pageSize = 10;
        boolean browsing = true;

        while (browsing) {
            DisplayUtil.displayProducts(products, currentIndex, currentIndex + pageSize);

            System.out.println("\nOptions:");
            if (currentIndex > 0) {
                System.out.println("P - Previous");
            }
            if (currentIndex + pageSize < products.size()) {
                System.out.println("N - Next");
            }
            System.out.println("B - Back to Menu");
            System.out.print("\nEnter option: ");

            String option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "N":
                    if (currentIndex + pageSize < products.size()) {
                        currentIndex += pageSize;
                    } else {
                        System.out.println("\n✗ Already at the last page.");
                    }
                    break;
                case "P":
                    if (currentIndex > 0) {
                        currentIndex -= pageSize;
                    } else {
                        System.out.println("\n✗ Already at the first page.");
                    }
                    break;
                case "B":
                    browsing = false;
                    break;
                default:
                    System.out.println("\n✗ Invalid option.");
            }
        }
    }

    private void addItemToCart() {
        System.out.print("\nEnter Product ID (e.g., 001): ");
        String id = scanner.nextLine();


