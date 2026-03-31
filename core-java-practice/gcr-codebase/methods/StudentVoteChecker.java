import java.util.Scanner;

public class StudentVoteChecker {

    public static boolean canStudentVote(int age){
        return age>=18;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int []ages = new int[10];

        for(int i=0;i<10;i++){
            System.out.print("Enter age of student "+(i+1)+": ");
            ages[i]=scan.nextInt();
            while(ages[i]<0){
                System.out.print("Age can't be negative. Enter again: ");
                ages[i]=scan.nextInt();
            }
        }

        for (int i = 0; i < 10; i++) {
            if(canStudentVote(ages[i])){
                System.out.println("Student "+(i+1)+" is eligible to vote.");
            }
            else{
                System.out.println("Student "+(i+1)+" is not eligible to vote.");
            }
        }
    }
}
