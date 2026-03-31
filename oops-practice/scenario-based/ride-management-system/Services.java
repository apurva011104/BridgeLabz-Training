import java.util.ArrayList;
import java.util.List;

public class Services {

    private List<Driver> drivers = new ArrayList<>();
    private List<Ride> rideHistory = new ArrayList<>();

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public Ride bookRide(User user, String rideType, double distance, FareCalculator fareCalculator) throws NoDriverAvailableException {

        Driver assignedDriver = null;

        for (Driver driver : drivers) {
            if (driver.getIsAvailable() && driver.getVehicleType().equals(rideType)) {
                assignedDriver = driver;
                break;
            }
        }

        if (assignedDriver == null) {
            throw new NoDriverAvailableException();
        }

        assignedDriver.setIsAvailable(false);

        double rideTypeMultiplier;
        switch (rideType){
            case "two wheeler":
                rideTypeMultiplier=1;
                break;
            case "three wheeler":
                rideTypeMultiplier=1.25;
                break;
            case "four wheeler":
                rideTypeMultiplier=1.5;
                break;
            default:
                rideTypeMultiplier=1;
        }

        double fare = fareCalculator.calculateFare(distance,rideTypeMultiplier);
        Ride ride = new Ride(user, assignedDriver, rideType, distance, fare);

        rideHistory.add(ride);
        return ride;
    }

    public void showRideHistory(Ride ride){
        ride.displayRideDetails();
    }

    public void showAllRidesHistory() {
        for (Ride ride : rideHistory) {
            ride.displayRideDetails();
            System.out.println();
        }
    }

}
