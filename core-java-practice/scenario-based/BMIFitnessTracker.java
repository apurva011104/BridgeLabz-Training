import java.util.Scanner;

public class BMIFitnessTracker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Maya's BMI Fitness Tracker!");
        System.out.println("Weight chart reference:");
        System.err.println("----------------------------------------------------------------");
        System.out.println("Body Weight Classification      |       BMI Range (kg/m²)");
        System.out.println("Underweight                     |           < 18.5");
        System.out.println("Normal                          |           18.5 to 24.9");
        System.out.println("Overweight                      |           25 to 29.9");
        System.out.println("Obesity                         |           BMI ≥ 30");
        System.err.println("----------------------------------------------------------------");

        //Taking weight and height input from client
        System.out.print("Please enter your weight in kilograms: ");
        double weight = scan.nextDouble();
        System.out.print("Please enter your height in centimeters: ");
        double height = scan.nextDouble();

        //Calculating BMI
        double heightInMeters = height / 100;
        double bmi = weight / (heightInMeters * heightInMeters);
        String status;
        if(bmi < 18.5){
            status="Underweight";
        }
        else if( bmi>=18.5 && bmi<25){
            status="Normal";
        }
        else if( bmi>=25 && bmi<40){
            status="Overweight";
        }
        else{
            status="Obesity";
        }

        System.out.println("-----------------------------------------------------------");
        System.out.println("Client's BMI Report:");
        System.out.printf("Weight          %.2f kg\n", weight);
        System.out.printf("Height          %.2f cm\n", height );
        System.out.printf("BMI             %.2f kg/m²\n", bmi);
        System.out.println("Status          " + status);
        System.out.println("-----------------------------------------------------------");
        System.err.println("Thank you for using Maya's BMI Fitness Tracker! Stay healthy and fit!");

        scan.close();
    }
}
