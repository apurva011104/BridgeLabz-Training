import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyBlockExecutionExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Enter dividend: ");
            int dividend = scan.nextInt();
            System.out.print("Enter divisor: ");
            int divisor = scan.nextInt();

            try {
                int quotient = dividend/divisor;
                System.out.println("Quotient: "+quotient);
            } 
            catch (ArithmeticException e) {
                System.out.println("Can't be divided by 0.");
            }
            finally{
                System.out.println("Operation completed.");
            }
        } 
        catch (InputMismatchException e) {
            System.out.println("Enter valid integers.");
        }
    }
}
