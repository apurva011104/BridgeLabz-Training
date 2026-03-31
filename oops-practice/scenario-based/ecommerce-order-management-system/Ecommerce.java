import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ecommerce{

    private final static Scanner SCANNER= new Scanner(System.in);
    private String name;
    private List<String> allProductIDs;
    private List<String> allCustomerIDs;
    private List<String> allOrderIDs;
    private List<Product> productsRecord;
    private List<Customer> customersRecord;
    private List<Order> ordersRecord;

    public Ecommerce(String name) {
        this.name = name;
        this.allCustomerIDs= new ArrayList<>();
        this.allProductIDs= new ArrayList<>();
        this.allOrderIDs= new ArrayList<>();
        this.ordersRecord= new ArrayList<>();
        this.productsRecord= new ArrayList<>();
        this.customersRecord= new ArrayList<>();
    }

    private String idGenerator(String prefix){

        String generatedID;

        do { 
            StringBuilder id = new StringBuilder();
            for(int i=0;i<12;i++){
                int charType=(int)(Math.random()*3);

                switch (charType){
                    case 0 -> id.append((char)((int)(Math.random()*26)+'a'));
                    case 1 -> id.append((char)((int)(Math.random()*26)+'A'));
                    case 2 -> id.append((char)((int)(Math.random()*10)+'0'));
                }
            }
            generatedID = prefix + id.toString();
        } 
        while (prefix.equals("PROD")?allProductIDs.contains(generatedID):(prefix.equals("CST")?allCustomerIDs.contains(generatedID):allOrderIDs.contains(generatedID)));
        return generatedID;
    }

    /*-------------------------------------CREATE OPERATIONS----------------------------------------------*/
    public Customer addCustomer(String customerName){
        Customer customer = new Customer(idGenerator("CST"), customerName);
        allCustomerIDs.add(customer.getCustomerID());
        customersRecord.add(customer);
        return customer;
    }

    public Product addProduct(String productName, String category, double pricePerUnit){
        Product product = new Product(idGenerator("PROD"), productName, category, pricePerUnit);
        allProductIDs.add(product.getProductId());
        productsRecord.add(product);
        return product;
    }

    public Order createOrder(Customer customer, String deliveryLocation){
        if(!customersRecord.contains(customer)){
            System.out.println("Customer not found in the record");
            return null;
        }
        Order order = new Order(idGenerator("ODR"), customer, deliveryLocation);
        allOrderIDs.add(order.getOrderID());
        ordersRecord.add(order);
        return order;
    }

    /*-------------------------------------READ OPERATIONS----------------------------------------------*/
    public void displayAllOrdersHistory(){
        System.out.println("All orders history: ");
        for(Order order: ordersRecord){
            order.displayOrderDetails();
        }
    }

    public void displayAllCustomers(){
        int index=1;
        System.out.println("All customers information: ");
        for(Customer customer: customersRecord){
            System.out.print(index+". ");
            customer.displayInfo();
            index++;
        }
    }

    public void displayAllProducts(){
        int index=1;
        System.out.println("Products catalog: ");
        for(Product product: productsRecord){
            System.out.print(index+". ");
            product.displayProductDetails();
            index++;
        }
    }

    public void displayCustomerOrderHistory(Customer customer){
        if(!customersRecord.contains(customer)){
            System.out.println("Customer not found in record");
            return;
        }
        System.out.println("Customer "+ customer.getCustomerID()+" orders history: ");
        for(Order order: ordersRecord){
            if(customer.equals(order.getCustomer())){
                order.displayOrderDetails();
            }
        }
    }

    /*-------------------------------------UPDATE OPERATIONS----------------------------------------------*/
    public void addProductToOrder(Order order, Product product, int quantity){
        if(order==null || !ordersRecord.contains(order)){
            System.out.println("Order not found in the record");
            return;
        }
        if(!productsRecord.contains(product)){
            System.out.println("Product not found in the record");
            return;
        }
        order.addProduct(product, quantity);
        System.out.println("Product added successfully");
    }

    public void removeProductFromOrder(Order order, Product product){
        if(order==null || !ordersRecord.contains(order)){
            System.out.println("Order not found in the record");
            return;
        }
        if(!productsRecord.contains(product)){
            System.out.println("Product not found in the record");
            return;
        }
        order.removeProduct(product);
        System.out.println("Product removed successfully");
    }
    public void cancelOrder(Order order){
        if(order==null){
            System.out.println("Non-existing order can't be cancelled");
            return;
        }
        if(order.cancellationStatus()){
            System.out.println("Order is cancelled already");
            return;
        }
        order.updateCancelled();
        System.out.println("Order cancelled successfully");
    }

    public void processOrder(Order order){
        if(order==null){
            System.out.println("Non-existing order can't be processed");
            return;
        }
        if(order.getProductsList().isEmpty()){
            System.out.println("Products list is empty");
            return;
        }
        Customer customer = order.getCustomer(); 
        List<Payment> paymentMethods = customer.getPaymentMethods();
        if(paymentMethods.isEmpty()){
            System.out.println("Please add a payment method before processing payment");
            return;
        }

        int index=1;
        try {
            System.out.println("Select a payment method");
            for(Payment payment: paymentMethods){
                System.out.print("Enter '"+(index)+"' for ");
                payment.paymentMethodDetail();
                index++;
            }
            System.out.print("Enter your choice of payment: ");
            int paymentChoice = SCANNER.nextInt();
            if(paymentChoice<=0 || paymentChoice>paymentMethods.size()){
                System.out.println("Invalid input. Processing order failed");
                return;
            }
            order.processPayment(paymentMethods.get(paymentChoice-1));
            System.out.println("Order placed successfully");
            order.displayOrderDetails();
        } 
        catch (Exception e) {
            System.out.println("Invalid input. Processing order failed");
            SCANNER.nextLine();
        }
    }

    /*-------------------------------------DELETE OPERATIONS----------------------------------------------*/
    public void removeCustomer(Customer customer){
        if(!customersRecord.contains(customer)){
            System.out.println("Customer not found in record");
            return;
        }
        ArrayList<Order> orderToRemove = new ArrayList<>();
        for(Order order: ordersRecord){
            if(order.getCustomer().equals(customer) && !order.paymentStatus()){
                orderToRemove.add(order);
            }
        }
        for(Order order: orderToRemove){
            ordersRecord.remove(order);
        }
        allCustomerIDs.remove(customer.getCustomerID());
        customersRecord.remove(customer);
        System.out.println("Customer deleted successfully");
    }

    public void removeProduct(Product product){
        if(!productsRecord.contains(product)){
            System.out.println("Product not found in record");
            return;
        }
        for(Order order: ordersRecord){
            if(!order.paymentStatus()){
                order.removeProduct(product);
            }
        }
        allProductIDs.remove(product.getProductId());
        productsRecord.remove(product);
        System.out.println("Product removed from inventory successfully");
    }
}