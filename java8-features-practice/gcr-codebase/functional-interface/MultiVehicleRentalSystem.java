public class MultiVehicleRentalSystem {
    
    public static void main(String[] args) {
        
        Vehicle car = new Car("CAR123","Wagon R");
        Vehicle bike = new Bike("BIK258", "Apache");
        Vehicle bus = new Bus("BUS357","Double decker");

        Vehicle[] vehicles = {car, bike, bus};

        for(Vehicle vehicle: vehicles){
            vehicle.rent();
        }

        car.rent();

        for(Vehicle vehicle: vehicles){
            vehicle.returnVehicle();
        }
    }
}

interface VehicleRentalInterface{
    void rent();
    void returnVehicle();
}

abstract class Vehicle implements VehicleRentalInterface{
    String id;
    String model;
    boolean isAvailable;

    public Vehicle(String id, String model) {
        this.id = id;
        this.model = model;
        this.isAvailable=true;
    }
}

class Car extends Vehicle{

    public Car(String id, String model) {
        super(id, model);
    }

    public void rent(){
        if(isAvailable){
            System.out.println("Car with id "+id+" rented successfully");
            isAvailable=false;
        }
        else{
            System.out.println("Car with id "+id+" not available to rent");
        }
    }

    public void returnVehicle(){
        if(isAvailable){
            System.out.println("Car with id "+id+" was never rented");
        }
        else{
            isAvailable=true;
            System.out.println("Car with id "+id+" returned successfully");
        }
    }
    
}

class Bike extends Vehicle{

    public Bike(String id, String model) {
        super(id, model);
    }

    public void rent(){
        if(isAvailable){
            System.out.println("Bike with id "+id+" rented successfully");
            isAvailable=false;
        }
        else{
            System.out.println("Bike with id "+id+" not available to rent");
        }
    }

    public void returnVehicle(){
        if(isAvailable){
            System.out.println("Bike with id "+id+" was never rented");
        }
        else{
            isAvailable=true;
            System.out.println("Bike with id "+id+" returned successfully");
        }
    }
    
}


class Bus extends Vehicle{

    public Bus(String id, String model) {
        super(id, model);
    }

    public void rent(){
        if(isAvailable){
            System.out.println("Bus with id "+id+" rented successfully");
            isAvailable=false;
        }
        else{
            System.out.println("Bus with id "+id+" not available to rent");
        }
    }

    public void returnVehicle(){
        if(isAvailable){
            System.out.println("Bus with id "+id+" was never rented");
        }
        else{
            isAvailable=true;
            System.out.println("Bus with id "+id+" returned successfully");
        }
    }
    
}
