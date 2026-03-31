
import java.util.HashSet;
import java.util.Scanner;

public class BasicCalculator {

    public static int sum(int num1, int num2){
        return num1+num2;
    }
    public static int difference(int num1, int num2){
        return num1-num2;
    }
    public static long product(int num1, int num2){
        return num1*num2;
    }
    public static double division(int num1, int num2){
        return num1/num2;
    }

    public static void additionOperation(int num1, int num2){
        int sum = sum(num1,num2);
        System.out.printf("%d + %d = %d",num1,num2,sum);
    }

    public static void subtractionOperation(int num1, int num2){
        int difference = difference(num1, num2);
        System.out.printf("%d - %d = %d",num1,num2,difference);
    }

    public static void multplicationOperation(int num1, int num2){
        long product = product(num1, num2);
        System.out.printf("%d * %d = %d",num1,num2,product);
    }

    public static void divisonOperation(int num1, int num2){
        try {
            double division = division(num1, num2);
            System.out.printf("%d / %d = %.3f",num1,num2,division);
        } 
        catch (ArithmeticException e) {
            System.out.println("Cannot be divided by 0");
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        HashSet<String> operations = new HashSet<>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");

        System.out.println("Enter '+' for addition\nEnter '-' for subtraction\nEnter '*' for multiplication\nEnter '/' for divison");
        System.out.print("Enter your choice: ");
        String operation = scan.next();
        while(!operations.contains(operation)){
            System.out.print("Please enter valid operation: ");
            operation=scan.next();
        }

        System.out.print("Enter num1: ");
        int num1= scan.nextInt();
        System.out.print("Enter num2: ");
        int num2 = scan.nextInt();

        switch(operation){
            case "+":
                additionOperation(num1, num2);
                break;
            case "-":
                subtractionOperation(num1, num2);
                break;
            case "*":
                multplicationOperation(num1, num2);
                break;
            case "/":
                divisonOperation(num1, num2);
                break;
            default:
                System.out.println("Invalid operation");
        }
        
    }
}
