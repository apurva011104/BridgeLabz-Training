import java.util.*;

public class CanStudentsVote {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Create an array to store ages of 10 students
        int[] ageOfStudents = new int[10];
        for(int i=0 ; i<ageOfStudents.length ; i++){
            System.out.print("Enter age of student "+(i+1)+": ");
            ageOfStudents[i]=scan.nextInt();
        }

        // Check voting eligibility
        for(int i=0 ; i<ageOfStudents.length ; i++){
            if(ageOfStudents[i]>=18){
                System.out.println("Student " + (i+1) + " with the age " + ageOfStudents[i] + " is eligible to vote.");
            }
            else{
                System.out.println("Student " + (i+1) + " with the age " + ageOfStudents[i] + " is not eligible to vote.");
            }
        }
        scan.close();
    }
}
