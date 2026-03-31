public class VehicleRentalSystem {
    
    public static void main(String[] args) {
        
        RentalServicesProvider services = new RentalServicesProvider("Rental Services");

        Vehicle bike1 = services.addBike("BIKE Model 27T Pulsar", "Motor bike", 700.0);
        Vehicle car1 = services.addCar("Volkswagen SUV", 1500.0);
        Vehicle truck1 = services.addTruck("Truck D5 Loader", 120, 2500.0);
        Vehicle car2 = services.addCar("BMW C47", 1200.0);

        Customer customer1 = services.addCustomer("Ava", 21);
        Customer customer2 = services.addCustomer("Rose", 24);
        Customer customer3 = services.addCustomer("Lily", 29);

        services.displayCustomerRecord();
        System.out.println();
        services.displayVehicleRecord();
        System.out.println();

        services.rentVehicle(customer1, car1, 5);
        System.out.println();
        services.rentVehicle(customer3, car2, 10);
        System.out.println();
        services.rentVehicle(customer2, car2, 7);
        System.out.println();
        services.rentVehicle(customer3, bike1, 6);
        System.out.println();

        services.displayRentedRecord();
        System.out.println();

        services.makeVehiclesAvailable(8);

        services.rentVehicle(customer2, car2, 7);
        System.out.println();
        services.rentVehicle(customer1, bike1, 14);
        System.out.println();

        services.removeVehicle(truck1);
        services.removeCustomer(customer3);

        services.displayCustomerRecord();
        System.out.println();
        services.displayVehicleRecord();
        System.out.println();


    }
}
