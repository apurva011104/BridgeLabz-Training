import java.util.Scanner;

public class CalculateSumUntilZero {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double sum = 0.0;
        System.out.println("Enter numbers to add and enter 0 to print their sum.");
        System.out.print("Enter a number: ");
        double value = scan.nextDouble();
        while(value == 0.0){
            sum += value;
            System.out.print("Enter a number: ");
            value = scan.nextDouble();
        }
        System.out.printf("The sum is: %.6f", sum);
        scan.close();
    }
}
