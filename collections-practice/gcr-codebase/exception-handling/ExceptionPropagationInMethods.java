import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionPropagationInMethods {
    
    public static int method1(int dividend, int divisor){
        return dividend/divisor;
    }

    public static void method2(int dividend, int divisor) {
        System.out.println("Quotient: "+method1(dividend, divisor));
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Enter dividend: ");
            int dividend = scan.nextInt();
            System.out.print("Enter divisor: ");
            int divisor = scan.nextInt();

            try {
                method2(dividend, divisor);
            } 
            catch (ArithmeticException e) {
                System.out.println("Can't be divided by 0. Handled exception in main");
            }
        } 
        catch (InputMismatchException e) {
            System.out.println("Enter valid integers.");
        }
    }
}
