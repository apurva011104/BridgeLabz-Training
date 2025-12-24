import java.util.Scanner;

public class WindChillTemperature {

    public static double calculateWindChill(double temperature, double windSpeed){
        double windChill= 35.74 + (0.6215 * temperature)+ (((0.4275 *temperature) - 35.75) * Math.pow(windSpeed,0.16));
        return windChill;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter temperature (in Fahrenheit): ");
        double temperature = scan.nextDouble();
        System.out.print("Enter wind speed (in mph): ");
        double windSpeed = scan.nextDouble();
        double windChill = calculateWindChill(temperature, windSpeed);
        System.out.printf("Wind chill temperature (in Fahrenheit): %.3f",windChill);
        scan.close();
    }
}
