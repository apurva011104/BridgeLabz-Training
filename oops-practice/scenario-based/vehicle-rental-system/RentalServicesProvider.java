import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RentalServicesProvider {
    
    private String name;
    private final Set<String> allCustomerIDs;
    private final Set<String> allVehicleIDs;
    private final List<Customer> customerRecord;
    private final List<Vehicle> vehicleRecord;
    private final List<Rented> rentedRecord;


    public RentalServicesProvider(String name) {
        this.name = name;
        this.allCustomerIDs = new HashSet<>();
        this.allVehicleIDs = new HashSet<>();
        this.customerRecord = new ArrayList<>();
        this.vehicleRecord = new ArrayList<>();
        this.rentedRecord= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private String generateID(String prefix){
        String id;
        do{
            id=IDGenerator.idGenerator(prefix);
        }
        while(prefix.equals("CST")?allCustomerIDs.contains(id):allVehicleIDs.contains(id));
        return id;
    }
    
    /*----------------------------------CREATE OPERATIONS---------------------------------------*/

    //Method to add customer
    public Customer addCustomer( String name, int age){
        Customer newCustomer = new Customer(generateID("CST"), name, age);
        allCustomerIDs.add(newCustomer.getCustomerID());
        customerRecord.add(newCustomer);
        return newCustomer;
    }

    //Method to add Car
    public Car addCar(String model, double rentalPricePerDay){
        Car newCar = new Car(generateID("CAR"), model, rentalPricePerDay);
        allVehicleIDs.add(newCar.getVehicleID());
        vehicleRecord.add(newCar);
        return newCar;
    }

    //Method to add Bike
    public Bike addBike(String model, String bikeType, double rentalPricePerDay){
        Bike newBike = new Bike(generateID("BIK"), model, rentalPricePerDay, bikeType);
        allVehicleIDs.add(newBike.getVehicleID());
        vehicleRecord.add(newBike);
        return newBike;
    }

    //Method to add Truck
    public Truck addTruck(String model, double payloadCapacity, double rentalPricePerDay){
        Truck newTruck = new Truck(generateID("TRK"), model, rentalPricePerDay, payloadCapacity);
        allVehicleIDs.add(newTruck.getVehicleID());
        vehicleRecord.add(newTruck);
        return newTruck;
    }

    /*----------------------------------READ OPERATIONS---------------------------------------*/

    //Method to display customer record
    public void displayCustomerRecord(){
        System.out.println("Customer Record: ");
        int index=1;
        for(Customer customer: customerRecord){
            System.out.print((index)+". ");
            customer.displayCustomerInfo();
            System.out.println("******************************");
            index++;
        }
    }
    
    //Method to display customer record
    public void displayVehicleRecord(){
        System.out.println("Vehicle Record: ");
        int index=1;
        for(Vehicle vehicle: vehicleRecord){
            System.out.print((index)+". ");
            vehicle.displayVehicleInfo();
            index++;
        }
    }

    //Method to display rented record
    public void displayRentedRecord(){
        System.out.println("Rented Record: ");
        int index=1;
        for(Rented rented: rentedRecord){
            System.out.print((index)+". ");
            rented.displayRentedInfo();
            index++;
        }
    }

    /*----------------------------------UPDATE OPERATIONS---------------------------------------*/

    //Method to rent vehicles
    public void rentVehicle(Customer customer, Vehicle vehicle, int rentalDays){
        if(!vehicleRecord.contains(vehicle)){
            System.out.println("No such vehicle found in the record");
            return;
        }
        if(!vehicle.getAvailability()){
            System.out.println("Vehicle not available to rent");
            return;
        }

        vehicle.updateAvailability(false);
        Rented rented = new Rented(customer, vehicle, rentalDays);
        rentedRecord.add(rented);
        customer.getRentedVehicles().add(rented);
        System.out.println("Vehicle rented successfully");
        rented.displayRentedInfo(); 
    }

    //Method to make vehicle available after rent period
    public void makeVehiclesAvailable(int numberOfDays){
        ArrayList<Rented> rentedRecordToDelete = new ArrayList<>();
        for(Rented rented: rentedRecord){
            if(rented.getRentalDays()>numberOfDays){
                rentedRecordToDelete.add(rented);
            }
        }
        for(Rented rented: rentedRecordToDelete){
            rented.getVehicle().updateAvailability(true);
            Customer customer = rented.getCustomer();
            customer.getRentedVehicles().remove(rented);
            rentedRecord.remove(rented);
        }
    }

    /*----------------------------------DELETE OPERATIONS---------------------------------------*/

    //Method to delete customer
    public void removeCustomer(Customer customer){
        if(!customerRecord.contains(customer)){
            System.out.println("No such customer found in record");
            return;
        }
        for(Rented rented: customer.getRentedVehicles()){
            rented.getVehicle().updateAvailability(true);
            rentedRecord.remove(rented);
        }
        customerRecord.remove(customer);
        allCustomerIDs.remove(customer.getCustomerID());
        System.out.println("Customer removed successfully");
    }

    //Method to delete vehicle
    public void removeVehicle(Vehicle vehicle){
        if(!vehicleRecord.contains(vehicle)){
            System.out.println("No such vehicle found in record");
            return;
        }
        ArrayList<Rented> rentedVehicles = new ArrayList<>();
        for(Rented rented: rentedRecord){
            if(rented.getVehicle().equals(vehicle)){
                rentedVehicles.add(rented);
            }
        }

        for(Rented rented: rentedVehicles){
            Customer customer = rented.getCustomer();
            customer.getRentedVehicles().remove(rented);
            rentedRecord.remove(rented);
        }
        allVehicleIDs.remove(vehicle.getVehicleID());
        vehicleRecord.remove(vehicle);
        System.out.println("Vehicle removed successfully");
    }

}
