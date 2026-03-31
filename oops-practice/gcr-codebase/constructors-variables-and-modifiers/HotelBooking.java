public class HotelBooking {
    
    String guestName;
    String roomType;
    int nights;

    //Default constructor
    public HotelBooking() {
        this("NA","NA",0);
    }

    //Parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    //Copy constructor
    HotelBooking(HotelBooking booking){
        this(booking.guestName,booking.roomType,booking.nights);
    }

    //Displaying details
    public void displayBookingDetails(){
        System.out.println("Guest name: "+guestName);
        System.out.println("Room type"+roomType);
        System.out.println("Number of nights: "+nights);
        System.out.println("--------------------------------------------");
    }

    public static void main(String[] args) {
        
        HotelBooking defaultBooking = new HotelBooking();
        HotelBooking parameterizedBooking = new HotelBooking("Ava","Deluxe",4);
        HotelBooking copyParameterizedBooking = new HotelBooking(parameterizedBooking);

        System.out.println("Default booking details: ");
        defaultBooking.displayBookingDetails();
        System.out.println("Parameterized booking details: ");
        parameterizedBooking.displayBookingDetails();
        System.out.println("Parameterized booking copy's details: ");
        copyParameterizedBooking.displayBookingDetails();
    }
    
}
