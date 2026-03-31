import java.util.Scanner;

public class FestivalLuckyDraw {

    //Method to draw number
    public static int drawANumber(){
        int number = (int)Math.ceil((Math.random()*99));
        return number;
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

        while(true){

            System.out.println("Welcome to Diwali Mela!");

            //Taking user input choice whether they want to draw a number
            System.out.print("Do you want to draw a number! Enter either 'yes' or 'no': ");
            String userChoice = takeUserInput(scan);

            if(userChoice.equals("yes")){
                //Drawing a number and checking whether visitor won or not
                int number=drawANumber();
                System.out.println("Number you drew: "+number);
                if(number%3==0 && number%5==0){
                    System.out.println("Congratulations! You won a gift. ^_^");
                }
                else{
                    System.out.println("Better luck next time! :)");
                }
                System.out.println("Thank you so much for playing ^_^");
            }
            else{
                System.out.println("It's okay! :)");
            }

            //Taking user input whether there is next customer in line or not
            System.out.print("Is there a next visitor in line? Enter either 'yes' or 'no': ");
            String isNextCustomerInLine = takeUserInput(scan);
            System.out.println("Thank you so much for visiting!");
            System.out.println("-----------------------------------------------------------------------------------------");
            if(isNextCustomerInLine.equals("no")){      //Breaking the loop if no next visitor in line
                break;
            }

        }
        System.out.println("Festival ended!");
        scan.close();
    }
}
