import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Order {
    
    protected static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);
    String orderId;
    LocalDate orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        try {
            this.orderDate = LocalDate.parse(orderDate,formatter);
        }
        catch (DateTimeParseException e) {
            System.out.println("Invalid date input");
        }
    }

    public void getOrderStatus(){
        System.out.println("Order placed");
        System.out.println("OrderId: "+orderId);
        System.out.println("Order Date: "+orderDate);
    }

}

class ShippedOrder extends Order{
    
    String trackingNumber;

    public ShippedOrder(String orderId, String orderDate,String trackingNumber) {
        super(orderId,orderDate);
        this.trackingNumber=trackingNumber;
    }

    @Override
    public void getOrderStatus(){
        super.getOrderStatus();
        System.out.println("Order shipped");
        System.out.println("Order tracking number: "+trackingNumber);
    }
    
}

class DeliveredOrder extends ShippedOrder{

    LocalDate deliveryDate;

    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate){
        super(orderId, orderDate, trackingNumber);
        try {
            this.deliveryDate = LocalDate.parse(deliveryDate,formatter);    
        } 
        catch (DateTimeParseException e) {
            System.out.println("Invalid delivery date");
        }
    }

    @Override
    public void getOrderStatus(){
        super.getOrderStatus();
        System.out.println("Order Delivered Successfully");
        System.out.println("Delivery date: "+deliveryDate);
    }
}

//Main class for testing
class Main{
    public static void main(String[] args) {
        
        Order order1 = new Order("OD101","12-05-2025");

        ShippedOrder order2 = new ShippedOrder("OD095","18-04-2025","T123456789");

        DeliveredOrder order3 = new DeliveredOrder("OD073", "10-02-2025", "T0472893415", "16-02-2025");

        order1.getOrderStatus();
        System.out.println();
        order2.getOrderStatus();
        System.out.println();
        order3.getOrderStatus();
        System.out.println();
    }
}