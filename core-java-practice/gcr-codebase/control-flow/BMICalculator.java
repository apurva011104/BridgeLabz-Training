import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //Taking weight and height input from user
        System.out.print("Enter your weight in kilograms: ");
        double weight = scan.nextDouble();
        System.out.print("Enter your height in centimeters: ");
        double height = scan.nextDouble();

        //Calculating BMI
        double heightInMeters = height / 100;
        double bmi = weight / (heightInMeters * heightInMeters);

        //Determining weight status
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

        System.out.printf("Your BMI is: %.2f", bmi);
        System.out.println("\nYour weight status is: " + status);
    }
}
