public class Vehicle2 {

    private final String id;
    String owner;
    double maxSpeed;
    String model;

    public Vehicle2(String id, String owner, double maxSpeed, String model) {
        this.id = id;
        this.owner = owner;
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    //Getter for Id
    public String getId(){
        return id;
    }

    public void displayInfo(){
        System.out.println("Id: "+id);
        System.out.printf("Maximum Speed: %.2fkmph%n",maxSpeed);
        System.out.println("Model: "+model);
    }
}


interface Refuelable{
    public void refuel();
}

class ElectricVehicle extends Vehicle2{

    double batteryCapacity;

    public ElectricVehicle(String id, String owner, double maxSpeed, String model, double batteryCapacity) {
        super(id, owner, maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }
    
    public void charge(){
        System.out.println("Charging Electric Vehicle.");
    }

    @Override
    public void displayInfo(){
        System.out.println("Vehicle type: Electric vehicle");
        super.displayInfo();
        System.out.printf("Battery capacity(in kWh): %.2f%n",batteryCapacity);
    }

}

class PetrolVehicle extends Vehicle2 implements Refuelable{

    int mileage;

    public PetrolVehicle(String id, String owner, double maxSpeed, String model, int mileage) {
        super(id, owner, maxSpeed, model);
        this.mileage = mileage;
    }

    @Override
    public void refuel(){
        System.out.println("Vehicle refueled");
    }

    @Override
    public void displayInfo(){
        System.out.println("Vehicle type: Electric vehicle");
        super.displayInfo();
        System.out.println("Battery capacity(in km/l): "+mileage);
    }

}

//Main class for testing
class Main{
    public static void main(String[] args) {
        PetrolVehicle petrolVehicle = new PetrolVehicle("PV101", "Ava", 140.0, "Honda City", 27);
        ElectricVehicle electricVehicle = new ElectricVehicle("EV110", "Avery", 80.0, "Tata Motors", 40);

        petrolVehicle.displayInfo();
        petrolVehicle.refuel();

        System.out.println();

        electricVehicle.displayInfo();
        electricVehicle.charge();
    }
}