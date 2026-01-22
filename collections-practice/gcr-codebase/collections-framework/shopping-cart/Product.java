public class Product {
    
    private final String productID;
    private final String name;

    public Product(String productID, String name) {
        this.productID = productID;
        this.name = name;
    }

    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString(){
        return "[Product ID: "+productID+", Name: "+name+"]";
    }
    
}
