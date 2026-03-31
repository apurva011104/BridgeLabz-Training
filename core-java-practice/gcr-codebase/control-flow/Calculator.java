import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Taking input of numbers and operator
        System.out.print("Enter first number: ");
        double num1 = scan.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scan.nextDouble();
        System.out.print("Enter '+' for addition");
        System.out.print("Enter '-' for subtraction");
        System.out.print("Enter '*' for multiplication");
        System.out.print("Enter '/' for division");
        String operator = scan.next();

        // Performing calculation based on operator
        double result=0.0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } 
                else {
                    System.out.println("Error: Division by zero is not allowed.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operator!");
        }

        System.out.printf(" %.3f %s %.3f = %.3f", num1, operator, num2, result);

        scan.close();

    }
}