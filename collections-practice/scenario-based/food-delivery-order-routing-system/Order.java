public class Order {
    
    private final String orderId;
    private final String customerName;
    private final double customerLocationInKilometers;
    private DeliveryStatus deliveryStatus;

    public Order(String orderId, String customerName, double customerLocationInKilometers) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.customerLocationInKilometers = customerLocationInKilometers;
        this.deliveryStatus = DeliveryStatus.PENDING;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getCustomerLocation() {
        return customerLocationInKilometers;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        if(this.deliveryStatus.equals(DeliveryStatus.CANCELLED)){
            return;
        }
        if(this.deliveryStatus.equals(DeliveryStatus.ASSIGNED) && !deliveryStatus.equals(DeliveryStatus.CANCELLED)){
            return;
        }
        this.deliveryStatus = deliveryStatus;
    }

    @Override
    public String toString() {
        return String.format("[Order ID: %s, Customer name: %s, Customer location: %.2f kms]", orderId, customerName, customerLocationInKilometers);
    }

}