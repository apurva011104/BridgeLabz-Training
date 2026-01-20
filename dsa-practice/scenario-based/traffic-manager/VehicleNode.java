public class VehicleNode {
    
    private final Vehicle vehicle;
    private VehicleNode next;

    public VehicleNode(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleNode(Vehicle vehicle, VehicleNode next) {
        this.vehicle = vehicle;
        this.next = next;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleNode getNext() {
        return next;
    }

    public void setNext(VehicleNode next) {
        this.next = next;
    }

}
