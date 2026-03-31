
import java.util.Scanner;

public class SandeepFitnessChallengeTracker {

    //Method to take valid user choice for rest day or not
    public static String takeRestDayInput(Scanner scan){
        String userInput = scan.next().toLowerCase();
        while(!userInput.equals("yes") && !userInput.equals("no")){
            System.out.print("Invalid input! Please enter either 'yes' or 'no': ");
            userInput = scan.next().toLowerCase();
        }
        return userInput;
    }

    //Method to take number of push ups input
    public static int takePushUpsInput(Scanner scan){
        int numberOfPushUps=scan.nextInt();
        while(numberOfPushUps<0){
            System.out.print("Please enter valid number of push-ups: ");
            numberOfPushUps=scan.nextInt();   
        }
        return numberOfPushUps;
    }

    //Method to count total number of pushups
    public static int totalPushUpsCount( int[] pushUpCount){
        int total = 0;
        for(int count: pushUpCount){
            total+=count;
        }
        return total;
    }

    //Method to display number of push ups each day
    public static void displayNumberOfPushUpsEachDay(int []pushUpCount){
        for(int i=0 ; i<pushUpCount.length ; i++){
            System.out.println("Day "+(i+1)+" push-ups count: "+pushUpCount[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int []pushUpCount = new int[7];     //Initializing an array to store number of push ups each day

        for(int i=1 ; i<=7 ; i++){

            System.out.println("Day "+i);
            System.out.println("Welcome Sandeep!");

            System.out.print("Is today a rest day? Enter either 'yes' or 'no': ");
            String isRestDay = takeRestDayInput(scan);
            if(isRestDay.equals("yes")){
                System.out.print("Rest is important to recover your body");
            }
            else{
                System.out.print("Enter number of push-ups done today: ");
                pushUpCount[i-1]=takePushUpsInput(scan);
                System.out.println("We appreciate your efforts!");
                
            }

            System.out.println("See you next day!");
            System.out.println("-------------------------------------------------------------------------");

        }
        
        int totalPushUpsCount = totalPushUpsCount(pushUpCount);
        int average = totalPushUpsCount / 7;
        
        //Displaying data of whole week
        System.out.println("Week data: ");
        displayNumberOfPushUpsEachDay(pushUpCount);
        System.out.println("Total number of push-ups: "+totalPushUpsCount);
        System.out.println("Average number of pushUps: "+average);
    }
}
