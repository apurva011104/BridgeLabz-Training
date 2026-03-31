import java.util.HashSet;
import java.util.Set;

public class Ride {
    
    private static Set<String> allRideIDs = new HashSet<>();
    private final String rideId;
    private User user;
    private Driver driver;
    private String rideType;
    private double distance;
    private double fare;

    public Ride(User user, Driver driver, String rideType, double distance, double fare) {
        this.rideId = generateRideId();
        this.user = user;
        this.driver = driver;
        this.rideType = rideType;
        this.distance = distance;
        this.fare = fare;
    }

    private static boolean isUniqueRideID(String rideId){
        return !allRideIDs.contains(rideId);
    }

    private static String generateRideId(){
        String rideId ="";
        do {
            StringBuilder id = new StringBuilder();
            for (int i = 0; i < 12; i++) {
                if (i < 5) {
                    id.append((char) ('A' + (int)(Math.random() * 26)));
                } else {
                    id.append((char) ('0' + (int)(Math.random() * 10)));
                }
            }
            rideId = id.toString();
        } 
        while (!isUniqueRideID(rideId));

        allRideIDs.add(rideId);

        return rideId;
    }


    public void displayRideDetails() {
        System.out.println("Ride ID: "+rideId);
        System.out.println("User name: "+user.getName());
        System.out.println("Driver name: "+driver.getName());
        System.out.println("Ride Type: "+rideType);
        System.out.printf("Distance travelled: %.2fkms%n",distance);
        System.out.printf("Fare: %.2f INR%n",fare);
    }

    public String getRideId() {
        return rideId;
    }

}
