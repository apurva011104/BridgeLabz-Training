import java.util.Scanner;

public class RockPaperScissor {

    final static String []rockPaperScissor = {"rock","paper","scissor"};
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int userWins=0, computerWins=0;
        for(int i=0;i<10;i++){
            System.out.print("Choose either rock/paper/scissor: ");
            String userChoice=scan.next().toLowerCase();
            while(!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissor")){
                System.out.print("Invalid choice! Choose again: ");
                userChoice=scan.next().toLowerCase();
            }

            String computerChoice= rockPaperScissor[(int)(Math.random()*2)];
            if(computerChoice.equals(userChoice)){
                System.out.println("Tie");
            }
            else if((computerChoice.equals("rock") && userChoice.equals("paper")) || (computerChoice.equals("paper") && userChoice.equals("scissor")) || (computerChoice.equals("scissor") && userChoice.equals("rock"))){
                System.out.println("User wins");
                userWins++;
            }
            else{
                System.out.println("Computer wins");
                computerWins++;
            }
        }
        System.out.println("No.of rounds: 10");
        System.out.println("User wins: "+userWins);
        System.out.println("Computer wins: "+computerWins);
        System.out.println("Tie matches: "+(10-userWins-computerWins));
        System.out.println("User winning rate: "+(userWins*10)+"%");
        System.out.println("Computer winning rate: "+(computerWins*10)+"%");
    }
}
