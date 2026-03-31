
import java.util.Scanner;

public class CalculateBonus {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        double []salary=new double[10];
        int []yearsOfExperience = new int[10];

        for(int i=0;i<10;i++){
            System.out.print("Enter salary of person "+i+": ");
            double s=scan.nextDouble();
            if(s<=0){
                System.out.println("Invalid input! Enter again.");
                i--;
                continue;
            }
            System.out.println("Enter years of experience of the person "+i+": ");
            int years=scan.nextInt();
            if(years<0){
                System.out.println("Invalid input! Enter again.");
                i--;
                continue;
            }
            yearsOfExperience[i]=years;
            salary[i]=s;
        }

        double bonus[]=new double[10];
        double []newSalary = new double[10];

        for(int i=0;i<10;i++){
            if(yearsOfExperience[i]>=5){
                bonus[i]=0.05*salary[i];
            }
            else{
                bonus[i]=0.02*salary[i];
            }
            newSalary[i]=salary[i]+bonus[i];
        }

        for(int i=0;i<10;i++){
            System.out.println("Person "+(i+1)+": ");
            System.out.printf("Old salary: %.3f",salary[i]);
            System.out.printf("\nBonus: %.3f",bonus[i]);
            System.out.printf("\nNew salary: %.3f",newSalary[i]);
            System.out.println("\n-----------------------------------------------------------------");
        }

        scan.close();
    }
}
