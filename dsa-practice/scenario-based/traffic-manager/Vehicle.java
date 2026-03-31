public class Vehicle {
    
    private final String vehicleId;
    private final String vehicleModel;

    public Vehicle(String vehicleId, String vehicleModel) {
        this.vehicleId = vehicleId;
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

}
