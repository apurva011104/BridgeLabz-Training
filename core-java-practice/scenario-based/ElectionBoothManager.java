import java.util.Scanner;

public class ElectionBoothManager{

    public static boolean isValidAge(int age){
        return age>=18;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int []candidates=new int[3];
        boolean flag=true;

        while(true){

            System.out.print("Enter age of voter: ");
            int age=scan.nextInt();
            while(age<0){
                System.out.print("Not a valid age! Enter again: ");
                age=scan.nextInt();
            }

            if(isValidAge(age)){

                System.err.println("You are eligible to vote!");
                System.out.println("Choose a party you want to cast your vote to.");
                System.out.println("Enter '1' for candidate A");
                System.out.println("Enter '2' for candidate B");
                System.out.println("Enter '3' for candidate C");
                System.out.print("Enter the candidate you selected: ");
                int party= scan.nextInt();
                while(party<1 || party>3){
                    System.out.print("Invalid party selected! Enter your input again: ");
                    party= scan.nextInt();
                }
                candidates[party-1]++;
                System.out.println("Thank you for casting your vote!");
            }
            else{
                System.out.println("You are not eligible to vote!");
            }

            System.out.print("Is there a new voter in line? Enter 'yes' or 'no'.");
            String newVoterInLine=scan.next().toLowerCase();
            while(!newVoterInLine.equals("yes") && !newVoterInLine.equals("no")){
                System.out.print("Invaild input! Enter either 'yes' or 'no': ");
                newVoterInLine=scan.next();
            }
            if(newVoterInLine.equals("no")){
                break;
            }
        }

        System.out.println("Voting results: ");
        System.out.println("Votes recieved by candidate A: "+candidates[0]);
        System.out.println("Votes recieved by candidate B: "+candidates[1]);
        System.out.println("Votes recieved by candidate C: "+candidates[2]);

        if(candidates[0]>candidates[1] && candidates[0]>candidates[2]){
            System.out.println("Candidate A won!");
        }
        else if(candidates[0]<candidates[1] && candidates[1]>candidates[2]){
            System.out.println("Candidate B won!");
        }
        else if(candidates[0]<candidates[2] && candidates[1]<candidates[2]){
            System.out.println("Candidate C won!");
        }
        else{
            System.out.println("There's a tie for winner.");
        }
            
        scan.close();

    }
}