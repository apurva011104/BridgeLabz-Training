import java.util.Scanner;

public class MaximumOfThreeNumbers {

    //Method too take user inputs
    public static int[] takeInputs(Scanner scan){
        System.out.print("Enter first number: ");
        int num1=scan.nextInt();
        System.out.print("Enter second number: ");
        int num2=scan.nextInt();
        System.out.print("Enter third numbber: ");
        int num3=scan.nextInt();
        return new int[]{num1,num2,num3};
    }

    //Method to find maximum number
    public static int findMaximum(int[] numbers) {
        int maximum=numbers[0];
        for (int num: numbers) {
            maximum=Math.max(num,maximum);
        }
        return maximum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = takeInputs(scan);
        int maximum = findMaximum(numbers);
        System.out.println("Maximum number: "+maximum);
        scan.close();
    }
}
