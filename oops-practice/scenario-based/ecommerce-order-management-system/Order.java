import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Order {
    
    private final String orderID;
    private Customer customer; 
    private final Map<Product, Integer> productsList;
    private LocalDate orderDate;
    private String deliveryLocation;
    private boolean isCancelled;
    private Payment paymentMethod;
    private boolean isPaid;

    public Order(String orderID, Customer customer, String deliveryLocation) {
        this.orderID = orderID;
        this.customer = customer;
        this.productsList = new HashMap<>();
        this.orderDate = LocalDate.now();
        this.deliveryLocation = deliveryLocation;
        this.isCancelled = false;
        this.isPaid = false;
    }

    public void addProduct(Product product, int quantity){
        if(isPaid){
            System.out.println("Order has been processed");
            return;
        }
        if(isCancelled){
            System.out.println("Order has been cancelled");
            return;
        }
        productsList.putIfAbsent(product, 0);
        productsList.replace(product, productsList.get(product)+quantity);
    }

    public void removeProduct(Product product){
        if(isPaid){
            System.out.println("Order has been processed");
            return;
        }
        if(isCancelled){
            System.out.println("Order has been cancelled");
            return;
        }
        if(!productsList.containsKey(product)){
            System.out.println("No such product in product list");
            return;
        }
        productsList.remove(product);
    }

    public void displayOrderDetails(){
        System.out.println("*********************************************");
        System.out.println("Order ID: "+orderID);
        System.out.println("Order Date: "+orderDate);
        System.out.println("Delivery Location: "+deliveryLocation);
        System.out.println("Customer ID: "+customer.getCustomerID());
        System.out.println("Customer name: "+customer.getCustomerName());
        System.out.println("Products: ");
        displayProducts();
        System.out.println("Total amount: "+calculateTotalPrice());
        System.out.println("Payment Status: "+(isPaid?"Paid":"Not paid"));
        System.out.println("Payment method: "+(paymentMethod==null?"Not selected yet":(paymentMethod.getClass().getSimpleName())));
        System.out.println("Cancellation status: "+(isCancelled?"Cancelled":"In process"));
        System.out.println("*********************************************");
    }

    private void displayProducts(){
        int index=1;
        for(Map.Entry<Product, Integer> entry: productsList.entrySet()){
            Product product = entry.getKey();
            double totalPrice = entry.getValue() * product.getPricePerUnit();
            System.out.printf("%d. Product ID: %s, Product Name: %s, Price per unit: %.2fINR, Quantity: %d, Price: %.2fINR%n", 
                                index, product.getProductId(), product.getProductName(), product.getPricePerUnit(), entry.getValue(), totalPrice);
            index++;
        }
    }

    public double calculateTotalPrice(){
        double total = 0;
        for(Map.Entry<Product, Integer> entry: productsList.entrySet()){
            total += (entry.getValue() * entry.getKey().getPricePerUnit());
        }
        return total; 
    }

    public boolean cancellationStatus() {
        return isCancelled;
    }

    public void updateCancelled() {
        this.isCancelled = true;
    }

    public void processPayment(Payment paymentMethod) {
        if (isCancelled) {
            System.out.println("Cannot process payment. Order is cancelled.");
            return;
        }
        if(isPaid){
            System.out.println("Order has been paid already.");
            return;
        }
        try {
            this.paymentMethod = paymentMethod;
            paymentMethod.pay(calculateTotalPrice());
            isPaid=true;
            System.out.println("Payment successful!");
        } 
        catch (PaymentFailedException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getOrderID() {
        return orderID;
    }

    public Map<Product, Integer> getProductsList() {
        return productsList;
    }

    public boolean paymentStatus(){
        return isPaid;
    }


}
