import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatchBlocksExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter size of the array: ");
            int n = scanner.nextInt();
            int[] array =  new int[n];
            for(int i=0;i<n;i++){
                System.out.print("Enter an integer: ");
                array[i]= scanner.nextInt();
            }
            System.out.print("Enter an index: ");
            int index = scanner.nextInt();
            System.out.printf("Value stored at index '%d': %d%n",index,array[index]);

        } 
        catch (InputMismatchException e) {
            System.out.println("Input value must be a valid integer.");
        }
        catch(NegativeArraySizeException e){
            System.out.println("Array size cannot be negative.");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index!");
        }
        catch(NullPointerException e){
            System.out.println("Array is not initialized.");
        }
        

    }
}
