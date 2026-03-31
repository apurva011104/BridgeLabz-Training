import java.util.Scanner;

public class NumberGuessingGame {

    //Method to recieve user feedback
    public static String recieveFeedback(Scanner scan){
        String feedback = scan.next().toLowerCase();
        while(!feedback.equals("low") && !feedback.equals("high") &&  !feedback.equals("correct")){
            System.out.print("Please enter either low, high or correct: ");
            feedback = scan.next().toLowerCase();
        }
        return feedback;
    }

    //Method for guesses made by computer
    public static void computerGuess(Scanner scan){
        int startRange=1, endRange=100;
        boolean flag=true;
        while(flag){
            int guess = (int)(Math.random()*endRange);
            if(guess<startRange){
                guess=startRange;
            }    
            System.out.println("Computer guess: "+guess);
            System.out.print("Enter whether computer guess is correct, high or low?: ");
            String feedback=recieveFeedback(scan);
            switch(feedback){
                case "low":
                    startRange=guess+1;
                    break;
                case "high":
                    endRange=guess-1;
                    break;
                default:
                    flag=false;
            }
        }

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Think of an integer in between 1 and 100");
        computerGuess(scan);
        scan.close();
    }
}
