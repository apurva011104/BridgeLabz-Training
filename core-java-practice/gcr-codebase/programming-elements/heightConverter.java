import java.util.Scanner;

public class heightConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter height in centimeters: ");
        double centimeters = scan.nextDouble();               //Takes height input in centimeters
        double inches = centimeters / 2.54;                   //Converts centimeters to inches
        double feet = inches / 12.0;                         //Converts inches to feet
        System.out.println("Your height in cm is " + centimeters + " and in feet is " + feet + " and in inches is " + inches);
        scan.close();
    }
    
}
