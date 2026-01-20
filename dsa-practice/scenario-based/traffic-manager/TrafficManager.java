public class TrafficManager {

    private final Roundabout roundabout;
    private final VehicleQueue waitingQueue;

    public TrafficManager(int queueCapacity){
        this.roundabout = new Roundabout();
        this.waitingQueue = new VehicleQueue(queueCapacity);
    }

    public void vehicleArrives(String vehicleID, String model){
        try {
            if(waitingQueue.isVehicleInQueue(vehicleID)){
                System.out.println("Vehicle ID is already waiting in the queue");
                return;
            }
            if(roundabout.isVehicleInRoundabout(vehicleID)){
                System.out.println("Vehicle ID is present in the roundaout");
                return;
            }
            waitingQueue.enqueue(new Vehicle(vehicleID,model));
            System.out.printf("%s is added to waiting queue successfully%n",vehicleID);

        } 
        catch (QueueOverflowException e) {
            System.out.println(e);
        }
    }

    public void allowVehicleToEnter(){
        try {
            Vehicle vehicle = waitingQueue.dequeue();
            roundabout.addVehicle(vehicle);
            System.out.printf("Vehicle %s entered in roundabout successfully%n",vehicle.getVehicleId());
        } 
        catch (QueueUnderflowException e) {
            System.out.println(e);
        }
    }

    public void vehicleExits(String vehicleId){
        try {
            if (!roundabout.removeVehicle(vehicleId)) {
                System.out.println("Vehicle not found in roundabout");
            }

        }
        catch (EmptyRoundAboutException e) {
            System.out.println(e);
        }
    }

    public void printTrafficState() {
        roundabout.printState();
    }
}
