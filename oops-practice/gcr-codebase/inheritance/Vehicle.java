public class Vehicle {
    
    double maxSpeed;
    String fuelType;

    public Vehicle(double maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayInfo(){
        System.out.printf("Vehicle Maximum Speed: %.2fkmph%n",maxSpeed);
        System.out.println("Vehicle Fuel Type: "+fuelType);
        System.out.println();
    }
}


class Car extends Vehicle{

    int seatCapactity;

    public Car(double maxSpeed, String fuelType, int seatCapactity){
        super(maxSpeed, fuelType);
        this.seatCapactity = seatCapactity;
    }

    @Override
    public void displayInfo(){
        System.out.printf("Car Maximum Speed: %.2fkmph%n",maxSpeed);
        System.out.println("Car Fuel Type: "+fuelType);
        System.out.println("Car Seat Capacity: "+seatCapactity);
        System.out.println();
    }

}

class Truck extends Vehicle{
    
    String type;

    Truck(double maxSpeed, String fuelType, String type){
        super(maxSpeed, fuelType);
        this.type = type;
    }

    @Override
    public void displayInfo(){
        System.out.printf("Truck Maximum Speed: %.2fkmph%n",maxSpeed);
        System.out.println("Truck Fuel Type: "+fuelType);
        System.out.println("Truck Type: "+type);
        System.out.println();
    }

}

class Motorcycle extends Vehicle{

    double engineSize;

    public Motorcycle(double maxSpeed, String fuelType, double engineSize) {
        super(maxSpeed,fuelType);
        this.engineSize =engineSize;
    }

    @Override
    public void displayInfo(){
        System.out.printf("Motorcycle Maximum Speed: %.2fkmph%n",maxSpeed);
        System.out.println("Motorcycle Fuel Type: "+fuelType);
        System.out.printf("Motorcycle Engine Size: %.2fcc %n",engineSize);
        System.out.println();
    }
}

//Main class for testing
class Main{
    public static void main(String[] args) {
        
        Vehicle vehicle1 = new Vehicle(90, "Petrol");
        Car car1 = new Car(180.00, "Petrol",5);
        Truck truck1 = new Truck(240.00,"Diesel","Pickup");
        Motorcycle motorcycle1 = new Motorcycle(140.0,"Diesel",1400);

        Vehicle[] vehiclesArray = {vehicle1,car1,truck1,motorcycle1};       //Ploymorphism demonstration

        for(Vehicle vehicle: vehiclesArray){
            vehicle.displayInfo();
        }
    }
}