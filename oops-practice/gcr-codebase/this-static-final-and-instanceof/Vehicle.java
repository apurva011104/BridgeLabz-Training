public class Vehicle {
    
    //Static variable
    private static double registrationFee = 0.0;

    //Instance variables
    private final String registrationNumber;        //Final variable
    private String ownerName;
    private String vehicleType;

    //Constructor to create Vehicle object
    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        //Use of this keyword in constructor
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    //Getters and setters
    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }
    public String getRegistrationNumber(){
        return registrationNumber; 
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

    //Static method to update registration fee
    public static void updateRegistrationFee( double newRegistrationFee){
        registrationFee = newRegistrationFee;
    }

    //Instance method to display registration details
    public void displayVehicleDetails(){
        if(this instanceof Vehicle){        //Checking if the object is instance of the Student class
            System.out.println("Owner name: "+ownerName);
            System.out.println("Vehicle Type: "+vehicleType);
            System.out.println("Registration Number: "+registrationNumber);
            System.out.printf("Registration Fee: $%.1f%n",registrationFee);
        }
        else{
            System.out.println("Invalid vehicle instance");
        }
    }

    public static void main(String[] args) {
        updateRegistrationFee(150.0);

        Vehicle vehicle1 = new Vehicle("ABC123","Honest raj","Sedan");
        Vehicle vehicle2 = new Vehicle("XYZ789","Price danish","SUV");

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
        
    }
}
