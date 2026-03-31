import java.util.Scanner;

public class CalculateGrade {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        //Take marks input from user
        System.out.print("Enter number of students: ");
        int numberOfStudents=scan.nextInt();

        double physics[]=new double[numberOfStudents];
        double chemistry[]=new double[numberOfStudents];
        double maths[]=new double[numberOfStudents];

        for(int i=0;i<numberOfStudents;i++){
            System.out.println("Enter the following for student "+(i+1)+": ");
            System.out.print("Marks obtained in physics: ");
            physics[i]=scan.nextDouble();
            System.out.print("Marks obtained in chemistry: ");
            chemistry[i]=scan.nextDouble();
            System.out.print("Marks obtained in mathematics: ");
            maths[i]=scan.nextDouble();
        }
        
        //Calculating percentage
        double []percentage=new double[numberOfStudents];
        for(int i=0;i<numberOfStudents;i++){
            double total=physics[i]+chemistry[i]+maths[i];
            percentage[i]=(total/300.0)*100;
        }

        char grade[]=new char[numberOfStudents];
        String remark[]=new String[numberOfStudents];

         //Determining grade and remarks based on percentage
        for(int i=0;i<numberOfStudents;i++){
            if(percentage[i]>=80){
                grade[i]='A';
                remark[i]= "Level 4, above agency-normalized standards";
            }
            else if(percentage[i]>=70){
                grade[i]='B';
                remark[i]= "Level 3, at agency-normalized standards";
            }
            else if(percentage[i]>=60){
                grade[i]='C';
                remark[i]= " Level 2, below but approaching agency-normalized standards";

            }
            else if(percentage[i]>=50){
                grade[i]='D';
                remark[i]= "Level 1, well below agency-normalized standards";

            }
            else if(percentage[i]>=40){
                grade[i]='E';
                remark[i]= "Level 1-, too below agency-normalized standards";
            }
            else{
                grade[i]='R';
                remark[i]= " Remedial standards";
            }
        }

        for(int i=0;i<numberOfStudents;i++){
            System.out.println("Student "+(i+1)+" details:");
            System.out.println("Marks in Physics: "+physics[i]);
            System.out.println("Marks in Chemistry: "+chemistry[i]);
            System.out.println("Marks in Maths: "+maths[i]);
            System.out.printf("Percentage: %.3f",percentage[i]);
            System.out.println();
            System.out.println("Grade: "+grade[i]);
            System.out.println("Remark: "+remark[i]);
            System.out.println("--------------------------------------------------------");
        }

        scan.close();
    }
}
