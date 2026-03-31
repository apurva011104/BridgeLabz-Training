
import java.util.Scanner;

public class TemperatureConvertor {

    public static double convertFarhenheitIntoCelsius(double  farhenheit){
        return (farhenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusIntoFarhenheit(double celsius){
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter '1' if convert farhenheit to celsius.");
        System.out.println("Enter '2' if convert celsius to farhenheit.");
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();
        while(choice!=1 && choice!=2){
            System.out.print("Invalid choice! Enter again: ");
            choice = scan.nextInt();
        }

        if(choice==1){

            System.out.print("Enter temperature in farhenheit: ");
            double temperature = scan.nextDouble();
            double temperatureInCelsius = convertFarhenheitIntoCelsius(temperature);
            System.out.printf("Temperature in celsius: %.2f",temperatureInCelsius);

        }
        else{

            System.out.print("Enter temperature in celsius: ");
            double temperature = scan.nextDouble();
            double temperatureInFarhenheit = convertCelsiusIntoFarhenheit(temperature);
            System.out.printf("Temperature in farhenheit: %.2f",temperatureInFarhenheit);

        }

        scan.close();
    }
}
