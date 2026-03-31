//Main class for testing
public class RideManagementSystem {
    
    public static void main(String[] args) {
        
        try{

            Services service = new Services();

            Driver driver1 = new Driver("Ron", "7817023018","three wheeler");
            Driver driver2 = new Driver("Cassie", "7817023019","two wheeler");
            Driver driver3 = new Driver("Bella", "8817023019","four wheeler");

            service.addDriver(driver1);
            service.addDriver(driver2);
            service.addDriver(driver3);
            
            User user1 = new User("Ava","9528087376");
            User user2 = new User("Sophie","5428089436");

            Ride bookedRide1 = service.bookRide(user1,"two wheeler", 2.75, new NormalPricing());
            Ride bookedRide2 = service.bookRide(user2, "four wheeler", 3.75, new PeakPricing());

            service.showRideHistory(bookedRide1);
            System.out.println();
            service.showRideHistory(bookedRide2);
            System.out.println();
            service.showAllRidesHistory();
            
        }
        catch(InvalidPhoneNumberException e){
            System.out.println(e);
        }
        catch(PhoneNumberAlreadyExistsException e){
            System.out.println(e);
        }
        catch(NoDriverAvailableException e){
            System.out.println(e);
        }
    }
}
