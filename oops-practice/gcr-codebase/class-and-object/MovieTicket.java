public class MovieTicket {

    String movieName;
    String seatNumber;
    double price;
    boolean isBooked;

    //Constructor to create movie ticket
    public MovieTicket() {
        this.isBooked = false;
    }

    //Method to book ticket
    public void bookTicket(String movieName, String seatNumber, double price){
        if(isBooked){
            System.out.println("House full!!! sorry..... Ticket already booked");
            return;
        }
        isBooked=true;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked for movie: "+movieName);
        System.out.println("Seat number: "+seatNumber);
    }

    //Method to display ticket details
    public void displayTicketDetails(){
        if(!isBooked){
            System.out.print("Ticket have not booked yet....");
        }
        else{
            System.out.printf("Price: $%.2f%n",price);
        }
    }

    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket();

        ticket1.bookTicket("Dragon", "A10", 120);
        ticket1.bookTicket("Dragon", "A10", 120);
        ticket1.bookTicket("Dragon", "A10", 120);
        ticket1.displayTicketDetails();
        MovieTicket ticket2 = new MovieTicket();
        ticket2.bookTicket("Dragon", "A10", 120);
        ticket2.displayTicketDetails();
    }
    
}
