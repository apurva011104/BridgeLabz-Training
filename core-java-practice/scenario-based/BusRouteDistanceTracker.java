import java.util.Scanner;

public class BusRouteDistanceTracker {

    //Method to generate next stop distance in the range of [0.5,15]
    public static double nextStopDistance(){
        double nextStopDistance = (Math.random()*14.5)+0.5;
        return nextStopDistance;
    }

    //Method to take valid user input
    public static String takeUserInput(Scanner scan){
        String userInput = scan.next().toLowerCase();
        while(!userInput.equals("yes") && !userInput.equals("no")){
            System.out.print("Invalid input! Please enter either 'yes' or 'no': ");
            userInput = scan.next().toLowerCase();
        }
        return userInput;
    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        double totalDistanceCovered = 0.0;      //Initializing a variable to keep track of total distance covered by user
        System.out.println("Welcome to bus services!");

        while(true){

            double nextStopDistance = nextStopDistance();
            System.out.printf("Next stop is %.3f kms far away. %n",nextStopDistance);

            System.out.print("Do you want to travel to next stop? Enter either 'yes' or 'no': ");
            String userChoice = takeUserInput(scan);        //Taking user choice
            if(userChoice.equals("no")){        //Breaking the loop is user do not want to travel further
                break;
            }

            totalDistanceCovered+=nextStopDistance;
            System.out.println("Next stop reached.");

        }

        System.out.println("Thank you so much for using bus services! :)");
        System.out.printf("Total distance covered: %.3f kms",totalDistanceCovered);     //Dispplaying total distance travelled by user

        scan.close();
    }
}
