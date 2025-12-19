import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = scan.nextDouble();                  //Takes first number input
        System.out.print("Enter second number: ");
        double num2 = scan.nextDouble();                  //Takes second number input
        double sum = num1 + num2;                         //Calculates sum
        double difference = num1 - num2;                  //Calculates difference   
        double product = num1 * num2;                     //Calculates product
        double division = num1 / num2;                    //Calculates quotient
        System.out.println("The addition, subtraction, multiplication and division of the two numbers "+ num1 +" and " + num2 +" is "+ sum + ", " + difference + ", " + product + ", and " + division);
        scan.close();
    }
}
