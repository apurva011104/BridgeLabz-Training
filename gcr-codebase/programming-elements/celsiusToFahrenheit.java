import java.util.Scanner;

public class celsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double temp=scan.nextDouble();          //Takes temperature input in Celsius
        double fahrenheit=(temp*9/5)+32;        //Converts Celsius to Fahrenheit
        System.out.println("Temperature in Fahrenheit: "+fahrenheit);
    }
}
