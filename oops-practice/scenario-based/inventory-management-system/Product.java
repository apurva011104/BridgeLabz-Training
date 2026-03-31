public class Product {

    private final String productId;
    private String productName;
    private int quantity;
    private int reorderLevel;

    public Product(String productId, String productName, int quantity, int reorderLevel) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void updateReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public void displayProductDetails() {
        System.out.printf("Product ID: %s, Name: %s, Stock: %d, Reorder level: %d%n", productId, productName, quantity, reorderLevel);
    }
}
