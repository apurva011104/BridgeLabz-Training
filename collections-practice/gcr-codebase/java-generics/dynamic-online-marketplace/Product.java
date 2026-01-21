public class Product<T extends Category>{
    
    private final String productID;
    private String productName;
    private double price;
    private final T category;

    public Product(String productID, String productName, double price, T category) throws PriceNotInRangeException{
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        setPrice(price);
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) throws PriceNotInRangeException {
        if(price>category.getMaximumPrice() || price<category.getMinimumPrice()){
            throw new PriceNotInRangeException("Price out of range for "+category.getCategoryName()+" category");
        }
        this.price = price;
    }
    
}
