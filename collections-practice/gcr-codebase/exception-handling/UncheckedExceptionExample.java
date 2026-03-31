import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter dividend: ");
            int dividend = scanner.nextInt();
            System.out.print("Enter divisor: ");
            int divisor = scanner.nextInt();

            int quotient = dividend / divisor;

            System.out.println("Quotient: "+quotient);
        } 
        catch (InputMismatchException e) {
            System.out.println("Entered value must be a number");
        }
        catch(ArithmeticException e){
            System.out.println("Cannot be divide by 0.");
        }
    }
}
