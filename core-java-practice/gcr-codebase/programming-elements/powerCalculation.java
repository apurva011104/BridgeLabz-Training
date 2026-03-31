
import java.util.Scanner;

public class PowerCalculation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter base number: ");        
        int base = scan.nextInt();                     //Takes base number input
        System.out.print("Enter exponent number: ");         
        int exponent = scan.nextInt();                 //Takes exponent number input
        double result = Math.pow(base, exponent);      //Calculates power
        System.out.println(base + " raised to the power of " + exponent + " is: " + result);
        scan.close();
    }
}
