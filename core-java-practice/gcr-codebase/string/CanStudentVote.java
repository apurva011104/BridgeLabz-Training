import java.util.Scanner;

public class CanStudentVote {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n=scan.nextInt();
        int ageOfStudents[] = new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter age of student "+(i+1)+": ");
            ageOfStudents[i]=scan.nextInt();
        }
        String []canVote=new String[n];

        for(int i=0;i<n;i++){
            if(ageOfStudents[i]<0){
                canVote[i]="Age invalid. Not eligible to vote.";
            }
            else if(ageOfStudents[i]<18){
                canVote[i]="Below 18. Not eligible to vote.";
            }
            else{
                canVote[i]="Is or above 18. Eligible to vote.";
            }
        }

        for(int i=0;i<n;i++){
            System.out.println("Student "+(i+1)+"'s age: "+ageOfStudents[i]+". Their eligiblity status: "+canVote[i]);
        }

    }
}
