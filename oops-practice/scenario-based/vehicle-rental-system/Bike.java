public class Bike extends Vehicle {
    
    private String bikeType;

    public Bike(String BikeID, String model, double rentalPricePerDay, String bikeType) {
        super(BikeID,model,rentalPricePerDay);
        this.bikeType = bikeType;
    }

    @Override
    public void displayVehicleInfo(){
        System.out.printf("Vehicle Type: Bike, Vehicle Number: %s, Bike Type: %s, Model: %s, Rental Price (per day): %.2f INR%n",getVehicleID(), bikeType, getModel(), getRentalPricePerDay());
    }
}
