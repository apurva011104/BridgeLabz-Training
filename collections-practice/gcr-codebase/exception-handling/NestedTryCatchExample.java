import java.util.InputMismatchException;
import java.util.Scanner;

public class NestedTryCatchExample {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter size of the array: ");
            int n = scanner.nextInt();
            try {
                int[] array =  new int[n];
                for(int i=0;i<n;i++){
                    System.out.print("Enter an integer: ");
                    array[i]= scanner.nextInt();
                }
                System.out.print("Enter value of divisor: ");
                int divisor = scanner.nextInt();
                System.out.print("Enter an index: ");
                int index = scanner.nextInt();
                try {

                    int dividend = array[index];

                    try {

                        int quotient = dividend / divisor;
                        System.out.println("Quotient: "+quotient);

                    } 
                    catch (ArithmeticException e) {
                        System.out.println("Cannot be divided by zero!");
                    }

                } 
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid array index!");
                }

            } 
            catch (NegativeArraySizeException e) {
                System.out.println("Array size can't be negative.");
            }

        } 
        catch (InputMismatchException e) {
            System.out.println("Input value must be a valid integer.");
        }

        scanner.close();

    }
}
