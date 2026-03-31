import java.util.ArrayList;

public class Customer {
    
    private final String customerID;
    private String name;
    private int age;
    private ArrayList<Rented> rentedVehicles;

    public Customer(String customerID, String name, int age) {
        this.customerID = customerID;
        this.name = name;
        this.age = age;
        this.rentedVehicles = new ArrayList<>();
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void updateAge(int newAge){
        this.age=newAge;
    }
    
    public void displayCustomerInfo(){
        System.out.printf("Customer ID: %s, Customer Name: %s, Age: %d%n",customerID, name, age);
        if(!rentedVehicles.isEmpty()){
            System.out.println("Rented vehicles: ");
            int index=1;
            for (Rented vehicles: rentedVehicles) {
                System.out.print((index)+". ");
                vehicles.displayRentedInfo();
                index++;
            }
        }
    }

    public ArrayList<Rented> getRentedVehicles() {
        return rentedVehicles;
    }

}
