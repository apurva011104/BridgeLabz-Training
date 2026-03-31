public class Product {
    
    private final String productId;
    private String productName;
    private String category;
    private double pricePerUnit;

    public Product(String productId, String productName, String category, double pricePerUnit) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.pricePerUnit = pricePerUnit;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void updatePricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public void displayProductDetails(){
        System.out.printf("Product Id: %s, Product Name: %s, Category: %s, Price: %.2f INR%n", productId,productName,category,pricePerUnit);
    }

    public String getProductId() {
        return productId;
    }
    
}
