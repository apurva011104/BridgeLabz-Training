interface Insurable{
    public double calculateInsurance();
    public void getInsuranceDetails();
}

abstract class Vehicle implements  Insurable{

    private final String vehicleNumber;
    private String type;
    private  double rentalRate;
    private String insurancePolicyNumber;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber=setPolicyNumber();
    }

    private static String setPolicyNumber(){
        StringBuilder policyNumber= new StringBuilder();
        for(int i=0;i<12;i++){
            int character = (int)Math.floor(Math.random()*10);
            policyNumber.append((char)(character+'0'));
        }
        return policyNumber.toString();
    }

    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void updateInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public abstract double calculateRentalCost(int days);

    public String encryptPolicyNumber(){
        StringBuilder encrypted = new StringBuilder();
        String policyNumber = getInsurancePolicyNumber();
        for(int i = policyNumber.length()-1 ; i>=0 ; i--){
            if(policyNumber.length()-i<=4){
                encrypted.insert(0,policyNumber.charAt(i));
            }
            else{
                encrypted.insert(0,"*");
            }
        }
        return encrypted.toString();
    }

    @Override
    public void getInsuranceDetails(){
        System.out.println("Insurance Policy Number: "+encryptPolicyNumber());
    }
    
    public void displayDetails(int days) {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.printf("Rental Cost for " + days + " days: $%.2f%n",calculateRentalCost(days));
        System.out.printf("Insurance Cost: $%.2f%n", calculateInsurance());
        getInsuranceDetails();
        System.out.println();
    }

}


class Car extends Vehicle{

    Car(String vehicleNumber, String type, double rentalRate){
        super(vehicleNumber, type, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days){
        return days*getRentalRate();
    }

    @Override
    public double calculateInsurance(){
        return getRentalRate() * 0.17;
    }


}

class Bike extends Vehicle{

    Bike(String vehicleNumber, String type, double rentalRate){
        super(vehicleNumber, type, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days){
        return days*getRentalRate()*0.8;
    }

    @Override
    public double calculateInsurance(){
        return getRentalRate() * 0.1;
    }

}

class Truck extends Vehicle{

    Truck(String vehicleNumber, String type, double rentalRate){
        super(vehicleNumber, type, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days){
        return days*getRentalRate()*1.5;
    }

    @Override
    public double calculateInsurance(){
        return getRentalRate() * 0.25;
    }

}


//Main class for testing
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle car1 = new Car("VC001024","CARGO",25);
        Vehicle bike1 = new Bike("VB047590","Electric bike", 20);
        Vehicle truck1 = new Truck("VT478201", "Shipping", 37.5);

        Vehicle[] vehicles = {car1,bike1,truck1};

        for(Vehicle vehicle: vehicles){
            vehicle.displayDetails(7);
        }
    }
}
