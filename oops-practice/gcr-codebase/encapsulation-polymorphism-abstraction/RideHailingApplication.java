interface GPS {
    public String getCurrentLocation();
    public void updateLocation(String location);
}


abstract class Vehicle implements GPS {

    private final String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = "Unknown";
    }

    public String getVehicleId() {
        return vehicleId;
    }

    protected String getDriverName() {
        return driverName;
    }

    protected double getRatePerKm() {
        return ratePerKm;
    }

    // GPS implementation
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
    }

    // Abstract method
    protected abstract double calculateFare(double distance);

    // Concrete method to display vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.printf("Rate per Km: %.2f INR%n", ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }

    
}


class Car extends Vehicle {

    private static final double BASE_FARE = 50;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    protected double calculateFare(double distance) {
        return BASE_FARE + (distance * getRatePerKm());
    }
}


class Bike extends Vehicle {

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    protected double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}


class Auto extends Vehicle {

    private static final double AUTO_SURCHARGE = 20;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    protected double calculateFare(double distance) {
        return (distance * getRatePerKm()) + AUTO_SURCHARGE;
    }
}

/* Main class */
public class RideHailingApplication {

    public static void processRide(Vehicle vehicle, double distance) {
        vehicle.getVehicleDetails();
        System.out.printf("Distance Travelled: %.2f km%n", distance);
        System.out.printf("Total Fare: %.2f INR%n", vehicle.calculateFare(distance));
        System.out.println();
    }

    public static void main(String[] args) {

        Vehicle vehicle1 = new Car("VCAR148102", "Ava", 25);
        Vehicle vehicle2 = new Bike("VBIK578205", "Mia", 15);
        Vehicle vehicle3 = new Auto("VAUT471330", "Bella", 20);

        Vehicle[] vehicles = {vehicle1, vehicle2, vehicle3 };

        for (Vehicle vehicle : vehicles) {
            vehicle.updateLocation("City Center");
            processRide(vehicle, 18.5);
        }
    }
}
