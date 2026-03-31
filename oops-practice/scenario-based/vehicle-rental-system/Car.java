public class Car extends Vehicle{

    public Car(String carID, String model, double rentalPricePerDay) {
        super(carID,model,rentalPricePerDay);
    }
    
    @Override
    public void displayVehicleInfo(){
        System.out.printf("Vehicle Type: Car, Vehicle Number: %s, Model: %s, Rental Price (per day): %.2f INR%n",getVehicleID(), getModel(), getRentalPricePerDay());
    }
    
}
