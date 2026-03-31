abstract class Vehicle{
    
    private final String vehicleID;
    private String model;
    private double rentalPricePerDay;
    private boolean availability;

    public Vehicle(String vehicleID, String model, double rentalPricePerDay) {
        this.vehicleID = vehicleID;
        this.model = model;
        this.rentalPricePerDay = rentalPricePerDay;
        this.availability = true;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public String getModel() {
        return model;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void updateAvailability(boolean availability) {
        this.availability = availability;
    }

    public void updateRentalPricePerDay(double newRentalPricePerDay) {
        this.rentalPricePerDay = newRentalPricePerDay;
    }

    abstract void displayVehicleInfo();

}
