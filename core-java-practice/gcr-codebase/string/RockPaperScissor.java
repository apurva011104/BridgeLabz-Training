import java.util.Scanner;

public class RockPaperScissor {

    final static String []rockPaperScissor = {"rock","paper","scissor"};

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter rock/paper/scissor: ");
        String userChoice=scan.next().toLowerCase();
        if(!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissor") ){
            System.out.println("Invalid choice!");
            return;
        }
        
        String computerChoice= rockPaperScissor[(int)(Math.random()*2)];
        if(computerChoice.equals(userChoice)){
            System.out.println("Tie");
        }
        else if((computerChoice.equals("rock") && userChoice.equals("paper")) || (computerChoice.equals("paper") && userChoice.equals("scissor")) || (computerChoice.equals("scissor") && userChoice.equals("rock"))){
            System.out.println("User wins");
        }
        else{
            System.out.println("Computer wins");
        }
    }
}
