public class Product {

    private static int totalProducts=0;     //Class variable
    private String productName;             //Instance variable
    private double price;                   //Instance variable

    //Constructor to create product
    public Product(String productName, double price) {
        setProductName(productName);
        setPrice(price);
        totalProducts++;
    }

    //Getters and setters
    public void setProductName(String productName){
        this.productName = productName;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getProductName(){
        return productName;
    }

    public double getPrice(){
        return price;
    }

    private static int getTotalProducts(){
        return totalProducts;
    }

    //Class method to display total number of products
    public static void displayTotalProducts(){
        System.out.println("Total products: "+getTotalProducts());
    }

    //Instance method to display particular product details
    public void displayProductDetails(){
        System.out.println("---------------------------------------------------");
        System.out.println("Product name: "+getProductName());
        System.out.printf("Product price: $%.2f%n",getPrice());
        System.out.println("---------------------------------------------------");
    }
    
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 799.99);
        product1.displayProductDetails();
        displayTotalProducts();
        Product product2 = new Product("Smart Watch", 49.99);
        product2.displayProductDetails();
        displayTotalProducts();
    }
}
