import java.util.Scanner;

public class CalculateGrade {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        //Take marks input from user
        System.out.print("Enter the marks obtained in physics: ");
        int physics=scan.nextInt();
        System.out.print("Enter the marks obtained in chemistry: ");
        int chemistry=scan.nextInt();
        System.out.print("Enter the marks obtained in mathematics: ");
        int maths=scan.nextInt();

        //Calculating percentage
        int total=physics+chemistry+maths;
        double percentage=(total/300.0)*100;
        System.out.printf("Percentage: %.3f",percentage);
        System.out.println();
        
        //Determining grade and remarks based on percentage
        if(percentage>=80){
            System.out.println("Grade: A");
            System.out.println("Remarks: Level 4, above agency-normalized standards");
        }
        else if(percentage>=70){
            System.out.println("Grade: B");
            System.out.println("Remarks: Level 3, at agency-normalized standards");
        }
        else if(percentage>=60){
            System.out.println("Grade: C");
            System.out.println("Remarks: Level 2, below but approaching agency-normalized standards");

        }
        else if(percentage>=50){
            System.out.println("Grade: D");
            System.out.println("Remarks: Level 1, well below agency-normalized standards");

        }
        else if(percentage>=40){
            System.out.println("Grade: E");
            System.out.println("Remarks: Level 1-, too below agency-normalized standards");
        }
        else{
            System.out.println("Grade: F");
            System.out.println("Remarks: Remedial standards");
        }

        scan.close();
    }
}
