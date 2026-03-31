interface Taxable{
    public double calculateTax();
    public void getTaxDetails();
}

abstract class Product implements Taxable{

    private final String productId;
    private String name;
    private double price;
    private double gstPercentage;

    public Product(String productId, String name, double price, double gstPercentage) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.gstPercentage= gstPercentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    abstract double calculateDiscount();

    @Override
    public double calculateTax(){
        return (gstPercentage * getPrice())/100;
    }

    @Override
    public void getTaxDetails(){
        System.out.printf("GST: %.2f%%%n",gstPercentage);
    }

    protected double calculateTotalPrice(){
        double priceAfterAddingTax = calculateTax()+price;
        return priceAfterAddingTax;
    }
    
    protected double priceAfterDiscount(){
        return calculateTotalPrice() - calculateDiscount();
    }
    public void displayInfo(){
        System.out.println("Product ID: "+productId);
        System.out.println("Name: "+name);
        System.out.printf("Price per unit: %.2f INR%n",price);
        System.out.printf("GST Percentage: %.2f%%%n",gstPercentage);
        System.out.printf("Price after applying gst: %.2f INR%n", calculateTotalPrice());
        System.out.printf("Discounted price: %.2f INR%n",calculateDiscount());
        System.out.printf("Price to pay: "+priceAfterDiscount());
    }
}

class Electronics extends Product{

    private static double gstPercentage = 18;
    int warrantyPeriodInMonths;

    Electronics(String productId, String name, double price, int warrantyPeriodInMonths){
        super(productId, name, price,gstPercentage);
        this.warrantyPeriodInMonths = warrantyPeriodInMonths;
    }

    @Override
    public double calculateDiscount() {
        double totalPrice = calculateTotalPrice();

        double discountPercentage;
        if(totalPrice<1000){
            discountPercentage=0;
        }
        else if(totalPrice>=2500 && totalPrice<5000){
            discountPercentage =10;
        }
        else if(totalPrice>=5000 && totalPrice<7500){
            discountPercentage=15;
        }
        else if(totalPrice>=7500 && totalPrice<15000){
            discountPercentage=22.5;
        }
        else{
            discountPercentage=30;
        }
        return (totalPrice * discountPercentage)/100;
    }

}

class Clothing extends Product{

    private static double gstPercentage = 9;
    String typeOfCloth;

    Clothing(String productId, String name, double price, String typeOfCloth){
        super(productId, name, price, gstPercentage);
        this.typeOfCloth = typeOfCloth;
    }

    @Override
    public double calculateDiscount() {
        double totalPrice = calculateTotalPrice();

        double discountPercentage;
        if(totalPrice<1000){
            discountPercentage=0;
        }
        else if(totalPrice>=1000 && totalPrice<3000){
            discountPercentage =12;
        }
        else if(totalPrice>=3000 && totalPrice<5000){
            discountPercentage=18;
        }
        else{
            discountPercentage=22.5;
        }
        return (totalPrice * discountPercentage)/100;
    }

}

class Groceries extends Product{
    
    private static double gstPercentage = 5;
    private double quantity;

    Groceries(String productId, String name, double price, double quantity){
        super(productId, name, price,gstPercentage);
        this.quantity = quantity;
    }

    @Override
    public double calculateTotalPrice(){
        double priceAfterAddingTax = calculateTax()+(getPrice()*quantity);
        return priceAfterAddingTax;
    }

    @Override
    public double calculateDiscount() {
        double totalPrice = calculateTotalPrice();

        double discountPercentage;
        if(totalPrice<1000){
            discountPercentage=0;
        }
        else if(totalPrice>=1000 && totalPrice<2500){
            discountPercentage =12;
        }
        else if(totalPrice>=2500 && totalPrice<5000){
            discountPercentage=20;
        }
        else{
            discountPercentage=30;
        }
        return (totalPrice * discountPercentage)/100;
    }

}

//Main class for testing
public class EcommercePlatform {
    public static void main(String[] args) {
        
        Product electronics1 = new Electronics("ELE0184","Laptop",54000,18);
        Product clothing2 = new Clothing("CL00154", "Denim Jeans", 750, "Denim");
        Product groceries1 = new Groceries("GRC2540", "Detergent Powder", 400, 3);

        Product []products = {electronics1,clothing2,groceries1};
        for(int i=0;i<3;i++){
            products[i].displayInfo();
            System.out.println();
        }
    }
}
