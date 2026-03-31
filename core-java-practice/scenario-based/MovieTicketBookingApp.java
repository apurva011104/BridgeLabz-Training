
import java.util.Scanner;

public class MovieTicketBookingApp {

    static final String[] MOVIE_TYPE={"Action","Comedy","Drama","Fantasy","Horror","Romance","Sci-Fi","Thriller"};

    //Method to display movie types
    public static void displayMovieTypes(){
        for(int i=0;i<MOVIE_TYPE.length;i++){
            System.out.println((i+1)+". "+MOVIE_TYPE[i]);
        }
    }

    //Method to take movie type input
    public static String takeMovieTypeInput(Scanner scan){
        String movieType= scan.next().toLowerCase();
        while(!isMovieTypeValid(movieType)){
            System.out.print("Please enter a valid movie type: ");
            movieType = scan.next().toLowerCase();
        }
        return movieType;
    }

    //Method to check whether movie type is valid or not
    public static boolean isMovieTypeValid(String movieType){
        for(String movie: MOVIE_TYPE){
            if(movie.toLowerCase().equals(movieType)){
                return true;
            }
        }
        return false;
    }

    //Method to take seat type input
    public static String[] takeSeatTypeInput(Scanner scan){
        System.out.println("Seat types: ");
        System.out.println("Gold: INR 150");
        System.out.println("Silver: INR 120");
        System.out.print("Select seat type. Enter either 'silver' or 'gold': ");
        String seatType= scan.next().toLowerCase();
        while(!isSeatTypeValid(seatType)){
            System.out.print("Please enter a valid seat type: ");
            seatType = scan.next().toLowerCase();
        }
        int price = seatType.equals("gold")?150:120;
        return new String[]{seatType,Integer.toString(price)};
    }

    //Method to check whether seat type is valid or not
    public static boolean isSeatTypeValid(String seatType){
        return seatType.equals("gold") || seatType.equals("silver");
    }

    //Method to take user choice whether they want snacks or not
    public static String takeSnacksInput(Scanner scan){
        System.out.println("Snacks price: INR 150");
        System.out.print("Dp you want the snacks? Enter either 'yes' or 'no': ");
        String snacks= scan.next().toLowerCase();
        while(!snacks.equals("yes") && !snacks.equals("no")){
            System.out.print("Invalid input! Please enter either 'yes' or 'no': ");
            snacks = scan.next().toLowerCase();
        }
        return snacks;
    }

    //Method to calculate total bill
    public static int totalBill(int seatTypePrice, int snacksPrice){
        return seatTypePrice+snacksPrice;
    }

    //Method to display movie ticket
    public static void displayMovieTicket(String movieType, String[] seatTypeAndPrice, int snacksPrice){
        int totalBill=totalBill(Integer.parseInt(seatTypeAndPrice[1]), snacksPrice);
        System.out.println("Your ticket: ");
        System.out.println("Movie type  \t\t"+movieType);
        System.out.println("Seat type   \t\t"+seatTypeAndPrice[0]);
        System.out.println("Seat price  \t\t"+seatTypeAndPrice[1]);
        System.out.println("Snacks price\t\t"+snacksPrice);
        System.out.println("Total price \t\t"+totalBill);
    }


    //Method to take valid user input of next customer
    public static String takeUserInput(Scanner scan){
        System.out.print("Is there a next customer in line? Enter either 'yes' or 'no': ");
        String userInput = scan.next().toLowerCase();
        while(!userInput.equals("yes") && !userInput.equals("no")){
            System.out.print("Invalid input! Please enter either 'yes' or 'no': ");
            userInput = scan.next().toLowerCase();
        }
        return userInput;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){

            System.out.println("Welcome to movie ticket booking app!");

            displayMovieTypes();
            System.out.print("Select a movie type: ");
            String movieType = takeMovieTypeInput(scan);
            String []seatTypeAndPrice = takeSeatTypeInput(scan);
            String snacks = takeSnacksInput(scan);
            int snacksPrice = snacks.equals("yes")?150:0;

            displayMovieTicket(movieType,seatTypeAndPrice,snacksPrice);
            System.out.println("Thank you so much for visiting!");
            System.out.println("-----------------------------------------------------------------------------------------");

            String isNextCustomerInLine = takeUserInput(scan);
            if(isNextCustomerInLine.equals("no")){      //Breaking the loop if no next visitor in line
                break;
            }
        }

    }
}
