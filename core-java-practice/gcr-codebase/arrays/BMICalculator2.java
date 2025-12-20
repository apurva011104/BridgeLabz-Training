
import java.util.Scanner;

public class BMICalculator2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        System.out.print("Enter number of Persons: ");
        int numberOfPerson=scan.nextInt();

        double [][]personData=new double[numberOfPerson][3];

        for(int i=0;i<numberOfPerson;i++){
            System.out.print("Enter weight of person "+(i+1)+" in kilograms: ");
            double w = scan.nextDouble();
            if(w<=0){
                System.out.println("Not a valid weight. Enter again!");
                i--;
                continue;
            }
            System.out.print("Enter height of person "+(i+1)+" in centimeters: ");
            double h = scan.nextDouble();
            if(h<=0){
                System.out.println("Not a valid height. Enter again!");
                i--;
                continue;
            }
            personData[i][0]=w;
            personData[i][1]=h;
        }

        String status[]=new String[numberOfPerson];

        for(int i=0;i<numberOfPerson;i++){
            double heightInMeters = personData[i][1] / 100;
            personData[i][2] = personData[i][0]/ (heightInMeters * heightInMeters);

            double bmi=personData[i][2];
            if(bmi< 18.5){
                status[i]="Underweight";
            }
            else if( bmi>=18.5 && bmi<25){
                status[i]="Normal";
            }
            else if( bmi>=25 && bmi<40){
                status[i]="Overweight";
            }
            else{
                status[i]="Obesity";
            }
        }

        for(int i=0;i<numberOfPerson;i++){
            System.out.println("Person "+(i+1)+" details:");
            System.out.println("Weight: "+personData[i][0]+"kgs");
            System.out.println("Height: "+personData[i][1]+"cms");
            System.out.printf("BMI: %.3f kg per meter square\n",personData[i][2]);
            System.out.println("Status"+status[i]);
            System.out.println("---------------------------------------------------------");
        }

        scan.close();

    }
}
