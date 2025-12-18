import java.util.Scanner;

public class kilometersToMiles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double kilometers = scan.nextDouble();               //Takes distance input in kilometers
        double miles = kilometers * 0.621371;                //Converts kilometers to miles
        System.out.println("Distance in miles: " + miles); 
        scan.close();
    }
}
