import java.util.HashSet;
import java.util.Set;

public class Driver extends Person{


    private static  Set<String> allDriversID = new HashSet<>();

    private String vehicleType;
    private boolean isAvailable;

    public Driver(String name, String phoneNumber, String vehicleType) throws InvalidPhoneNumberException, PhoneNumberAlreadyExistsException {
        super(generateID(), name, phoneNumber);
        this.isAvailable = true;
        this.vehicleType = vehicleType;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    private static boolean isUniqueID(String id){
        return !allDriversID.contains(id);
    }

    private static String generateID(){
        String driverId ="DIV";
        do {
            StringBuilder id = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                id.append((char) ('0' + (int)(Math.random() * 10)));
            }
            driverId += id.toString();
        } 
        while (!isUniqueID(driverId));

        allDriversID.add(driverId);
        return driverId;
    }


}