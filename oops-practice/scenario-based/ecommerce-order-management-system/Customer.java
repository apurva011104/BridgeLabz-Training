import java.util.ArrayList;
import java.util.List;

public class Customer {
    
    private final String customerID;
    private String customerName;
    private List<Payment> paymentMethods;

    public Customer(String customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.paymentMethods = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void displayInfo(){
        System.out.printf("Customer ID: %s, Customer Name: %s%n",customerID,customerName);
    }

    public List<Payment> getPaymentMethods() {
        return paymentMethods;
    }

    public void addPaymentMethod(Payment newPaymentMethod) {
        if (!paymentMethods.contains(newPaymentMethod)) {
            paymentMethods.add(newPaymentMethod);
        }
    }

    public String getCustomerID() {
        return customerID;
    }
    
}
