public class Truck extends Vehicle{
    
    private double payloadCapacity;
    
    public Truck(String truckID, String model, double rentalPricePerDay, double payloadCapacity) {
        super(truckID,model,rentalPricePerDay);
        this.payloadCapacity = payloadCapacity;
    }
    
    @Override
    public void displayVehicleInfo(){
        System.out.printf("Vehicle Type: Truck, Vehicle Number: %s, Model: %s, Payload Capacity, %.2f kgs, Rental Price (per day): %.2f INR%n",getVehicleID(), getModel(), payloadCapacity, getRentalPricePerDay());
    }

    public double getPayloadCapacity() {
        return payloadCapacity;
    }
}
