import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowVsThrowsExample {
    
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException{
        if(amount<0 || rate<0 || years<0){
            throw new IllegalArgumentException("Invalid input: Amount, year and rate must be positive.");
        }
        return (amount * rate * years) / 100 ;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            System.out.print("Enter rate percentage: ");
            double rate = scanner.nextDouble();
            System.out.print("Enter number of years: ");
            int years = scanner.nextInt();

            double interest = calculateInterest(amount, rate, years);

            System.out.printf("Interest: %.2f",interest);

        } catch (InputMismatchException e) {
            System.out.println("Invalid value.");
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}
