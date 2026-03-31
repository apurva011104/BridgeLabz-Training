public class TrafficManagerMain {
    public static void main(String[] args) {
        TrafficManager manager = new TrafficManager(15);

        manager.vehicleArrives("ABC123", "model 1");
        manager.vehicleArrives("AB1234", "model 2");
        manager.vehicleArrives("ABC123", "model 1");

        manager.allowVehicleToEnter();

        manager.printTrafficState();
        manager.vehicleExits("ABC965");
    }
}
