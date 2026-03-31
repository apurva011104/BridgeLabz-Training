public class Vehicle {
    
    private String ownerName;           //Instance variables
    private String vehicleType;         //Instance variables
    private static double registrationFee = 200.00;

    //Constructor to create Vehicle object
    public Vehicle(String ownerName, String vehicleType) {
        setOwnerName(ownerName);
        setVehicleType(vehicleType);
    }

    //Getters and Setters
    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }

    public void setVehicleType(String vehicleType){
        this.vehicleType = vehicleType;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public String getVehicleType(){
        return vehicleType;
    }

    public static double getRegistrationFee(){
        return registrationFee;
    }
    
    //Class method to update registration fee
    public static void updateRegistrationFee(double newRegistrationFee){
        registrationFee = newRegistrationFee;
    }

    //Instance method to display vehicle details
    public void displayVehicleDetails(){
        System.out.println("Vehicle owner name: "+getOwnerName());
        System.out.println("Vehicle type: "+getVehicleType());
        System.out.printf("Registration fee: INR %.2f%n",getRegistrationFee());
        System.out.println("------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Ava", "Car");
        vehicle1.displayVehicleDetails();

        Vehicle vehicle2 = new Vehicle("Avery","Bike");
        vehicle2.displayVehicleDetails();

        updateRegistrationFee(250.00);

        vehicle1.displayVehicleDetails();
        
        vehicle2.displayVehicleDetails();

        Vehicle vehicle3 = new Vehicle("Bella","Scooter");
        vehicle3.displayVehicleDetails();
    }
}
