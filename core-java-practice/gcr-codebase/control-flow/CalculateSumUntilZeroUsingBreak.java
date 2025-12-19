import java.util.Scanner;

public class CalculateSumUntilZeroUsingBreak {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double sum = 0.0;
        System.out.println("Enter numbers to add and enter 0 to print their sum.");
        while(true){
            System.out.print("Enter a number: ");
            double value = scan.nextDouble();
            if(value == 0.0){
                break;
            }
            sum += value;
        }
        System.out.printf("The sum is: %.6f", sum);
        scan.close();
    }
}
