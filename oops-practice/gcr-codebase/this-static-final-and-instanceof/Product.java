public class Product {
    
    //Static variable
    private static double discount = 0.0;

    //Instance variables
    private final String productID;     //Final variable
    private String productName;
    private double price;
    private int quantity;

    //Constructor to create product object
    public Product(String productID, String productName, double price, int quantity) {
        //Use of this keywird in the constructor
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    //Getters and setters
    public void setProductName(String productName){
        this.productName=productName;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public String getProductId(){
        return productID;
    }
    public String getProductName(){
        return productName;
    } 
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }

    //Static method to get discount
    public static double getDiscount(){
        return discount;
    }

    //Static method to update discount
    public static void updateDiscount( double newDiscount){
        discount = newDiscount;
    }

    //Instance method to calculate price after discount
    public double priceAfterDiscount(){
        double discountAmount = (discount * price) / 100.0;
        return price - discountAmount;
    }

    //Instance method to display product details
    public void displayProductDetails(){
        if(this instanceof Product){
            System.out.println("Product ID: "+productID);
            System.out.println("Product Name: "+productName);
            System.out.printf("Price: $%.1f%n",price);
            System.out.println("Quantity: "+quantity);
            System.out.printf("Discount: %.1f%%%n",discount);
            System.out.printf("Price after Discount: $%.1f%n",priceAfterDiscount());
        }
        else{
            System.err.println("Invalid product instance");
        }
    }

    public static void main(String[] args) {
        
        updateDiscount(10.0);
        
        Product product1 = new Product("P001", "Laptop", 1200.0, 5);
        Product product2 = new Product("P002", "Smartphone", 800.0, 10);

        product1.displayProductDetails();
        product2.displayProductDetails();
    }
}
