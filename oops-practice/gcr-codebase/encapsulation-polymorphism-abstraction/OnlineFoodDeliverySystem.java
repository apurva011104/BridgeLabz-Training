interface Discountable {
    void applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem implements Discountable {

    private String itemName;
    private double price;
    private int quantity;
    private double discountAmount;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.discountAmount = 0;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    protected double getDiscountAmount() {
        return discountAmount;
    }

    protected void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    //Abstract method
    protected abstract double calculateTotalPrice();

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.printf("Price per unit: %.2f INR%n", price);
        System.out.println("Quantity: " + quantity);
        System.out.println(getDiscountDetails());
        System.out.printf("Total Price: %.2f INR%n", calculateTotalPrice());
    }

    @Override
    public void applyDiscount() {
        double total = price * quantity;
        double discountPercentage = 0;
        if (total>=300 && total<500) {
            discountPercentage = 10;
        }
        else if(total>=500 && total<750){
            discountPercentage = 15;
        }
        else if(total>=750 && total<1250){
            discountPercentage=20;
        }
        else{
            discountPercentage = 25;
        }
        
        discountAmount = (total * discountPercentage) / 100;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount Applied: " + discountAmount + " INR";
    }
}

class VegItem extends FoodItem {

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    protected double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - getDiscountAmount();
    }
}

class NonVegItem extends FoodItem {

    private static final double NON_VEG_CHARGE = 75;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    protected double calculateTotalPrice() {
        double total = (getPrice() * getQuantity()) + NON_VEG_CHARGE;
        return total - getDiscountAmount();
    }
}

public class OnlineFoodDeliverySystem {

    public static void createOrder(FoodItem item) {
        item.getItemDetails();
    }

    public static void main(String[] args) {

        FoodItem item1 = new VegItem("Veg Pizza", 250, 2);
        FoodItem item2 = new NonVegItem("Chicken Burger", 100, 4);

        FoodItem [] items = {item1,item2};

        for(FoodItem item: items){
            item.applyDiscount();
            createOrder(item);
            System.out.println();
        }
    }
}
