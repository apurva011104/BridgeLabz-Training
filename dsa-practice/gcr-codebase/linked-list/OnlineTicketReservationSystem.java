import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Ticket {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss").withResolverStyle(ResolverStyle.STRICT);
    private final String ticketId;
    private String customerName;
    private String movieName;
    private String seatNumber;
    private LocalDate bookingDate;
    private LocalTime bookingTime;

    public Ticket(String ticketId, String customerName, String movieName, String seatNumber, String bookingDate, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingDate = LocalDate.parse(bookingDate, dateFormatter);
        this.bookingTime = LocalTime.parse(bookingTime,timeFormatter);
    }


    public String getTicketId() {
        return ticketId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void displayTicket() {
        System.out.print("Ticket ID: " + ticketId);
        System.out.print(", Customer: " + customerName);
        System.out.print(", Movie: " + movieName );
        System.out.print(", Seat: " + seatNumber);
        System.out.println(", Time: " + bookingTime);
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }
}

// Node class
class TicketNode {

    private Ticket ticket;
    private TicketNode next;

    public TicketNode(Ticket ticket) {
        this.ticket = ticket;
        this.next = null;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public TicketNode getNext() {
        return next;
    }

    public void setNext(TicketNode next) {
        this.next = next;
    }
}

public class OnlineTicketReservationSystem {

    private Set<String> allTicketIds;
    private TicketNode ticketHead;
    private TicketNode ticketTail;

    public OnlineTicketReservationSystem() {
        allTicketIds = new HashSet<>();
    }

    private boolean ticketAlreadyExists(String ticketId) {
        return allTicketIds.contains(ticketId);
    }

    //Method to add ticket
    public void addTicket(String ticketId, String customerName, String movieName, String seatNumber, String bookingDate, String bookingTime) {

        if (ticketAlreadyExists(ticketId)) {
            System.out.println("Ticket ID already exists.");
            return;
        }

        try {
            Ticket ticket = new Ticket(ticketId, customerName, movieName, seatNumber,bookingDate, bookingTime);
            TicketNode newNode = new TicketNode(ticket);

            if (ticketHead == null) {
                ticketHead = ticketTail = newNode;
                newNode.setNext(ticketHead);
            }
            else {
                ticketTail.setNext(newNode);
                newNode.setNext(ticketHead);
                ticketTail = newNode;
            }

            allTicketIds.add(ticketId);
            System.out.println("Ticket booked successfully.");
        } 
        catch (DateTimeParseException e) {
            System.out.println("Invalid booking time");
        }
    }

    //Method to remove ticket
    public void removeTicket(String ticketId) {

        if (!ticketAlreadyExists(ticketId)) {
            System.out.println("No such ticket found.");
            return;
        }

        TicketNode current = ticketHead;
        TicketNode previous = ticketTail;

        do {
            if (current.getTicket().getTicketId().equals(ticketId)) {

                if (current == ticketHead && current == ticketTail) {
                    ticketHead = ticketTail = null;
                } else {
                    previous.setNext(current.getNext());
                    if (current == ticketHead) {
                        ticketHead = current.getNext();
                        ticketTail.setNext(ticketHead);
                    }
                    if (current == ticketTail) {
                        ticketTail = previous;
                    }
                }

                allTicketIds.remove(ticketId);
                current.setNext(null);
                current = null;
                System.out.println("Ticket removed successfully.");
                return;
            }

            previous = current;
            current = current.getNext();

        } 
        while (current != ticketHead);
    }

    //Method to count total tickets
    public int totalTickets() {

        if (ticketHead == null) {
            return 0;
        }

        int count = 0;
        TicketNode current = ticketHead;

        do {
            count++;
            current = current.getNext();
        } while (current != ticketHead);

        return count;
    }

    //Method to search by customer name or movie name
    public void searchTicket(String searchString) {

        if (ticketHead == null) {
            System.out.println("No tickets available.");
            return;
        }

        ArrayList<TicketNode> foundTickets = new ArrayList<>();

        TicketNode current = ticketHead;

        do {

            Ticket ticket = current.getTicket();

            if (ticket.getCustomerName().equalsIgnoreCase(searchString) || ticket.getMovieName().equalsIgnoreCase(searchString)) {
                foundTickets.add(current);
            }
            current = current.getNext();

        } 
        while (current != ticketHead);

        if(foundTickets.size()==0){
            System.out.println("No matching ticket found.");
        }
        else{
            System.out.println("Found tickets: ");
            for(TicketNode ticket: foundTickets){
                ticket.getTicket().displayTicket();
            }
        }
    }

    //Method to display all tickets
    public void displayAllTickets() {

        if (ticketHead == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode current = ticketHead;
        System.out.println("Booked Tickets:");

        do {
            current.getTicket().displayTicket();
            current = current.getNext();
        } while (current != ticketHead);
    }

    //Main method for testing
    public static void main(String[] args) {
        
        OnlineTicketReservationSystem reservationSystem = new OnlineTicketReservationSystem();

        reservationSystem.addTicket("TIC13131", "Ava", "Carol", "A210", "14/04/2014","14:02:46");
        reservationSystem.addTicket("TIC13472", "Avery", "Wonderland", "A275", "12/04/2017","05:12:24");
        reservationSystem.addTicket("TIC24131", "Sarah", "Carol", "A214", "22/09/2020","22:01:48");
        reservationSystem.addTicket("TIC17531", "Mia", "Pluto", "A147", "17/01/2015","10:46:14");
        reservationSystem.addTicket("TIC27547", "Ava", "Arcane", "A240", "27/11/2023","19:53:07");

        System.out.println("Total tickets: "+reservationSystem.totalTickets());

        reservationSystem.displayAllTickets();

        reservationSystem.searchTicket("Carol");
        reservationSystem.searchTicket("Ava");

        reservationSystem.removeTicket("TIC24131");

        reservationSystem.displayAllTickets();

        
    }
}
