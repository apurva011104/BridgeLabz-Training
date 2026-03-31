public class SmartVehicleDashboard {

    public static void main(String[] args) {
        Vehicle car = new Car("C123", "Model-1",50);
        ElectricCar electricCar = new ElectricCar("EC745","Electric-model-5",40,80);

        car.displaySpeed();

        electricCar.displaySpeed();
        electricCar.displayBattery();
    }
    
}

interface Vehicle{
    void displaySpeed();
}

interface ElectricVehicle extends Vehicle{
    int getBatteryPercentage();

    default void displayBattery() {
        System.out.println("Current battery percentage: " + getBatteryPercentage() + "%");
    }
}

class Car implements Vehicle{

    final String id;
    String modelName;
    double speed;

    public Car(String id, String modelName, double speed) {
        this.id = id;
        this.modelName = modelName;
        this.speed=speed;
    }

    public void displaySpeed(){
        System.out.println("Current car speed: "+speed+"km/hour");
    }

}

class ElectricCar implements ElectricVehicle{

    final String id;
    String modelName;
    double speed;
    int battery;

    public ElectricCar(String id, String modelName, double speed, int battery) {
        this.id = id;
        this.modelName = modelName;
        this.speed = speed;
        this.battery = battery;
    }

    @Override
    public void displaySpeed(){
        System.out.println("Current electric car speed: "+speed+"km/hour");
    }

    @Override
    public int getBatteryPercentage(){
        return battery;
    }
}
