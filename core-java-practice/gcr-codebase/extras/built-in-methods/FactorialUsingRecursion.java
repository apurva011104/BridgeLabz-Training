import java.util.Scanner;

public class FactorialUsingRecursion {

    //Method to take user input
    public static int takeUserInput(Scanner scan){
        System.out.print("Enter a non-negative integer: ");
        int num = scan.nextInt();
        while(num<0){
            System.out.print("Invalid integer! Please enter a non-negative integer: ");
            num=scan.nextInt();
        }
        return num;
    }

    //Method to find factorial using recursion
    public static long factorial(int num){
        if(num==0){
            return 1;
        }
        return num*factorial(num-1);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = takeUserInput(scan);
        long factorial = factorial(num);
        System.out.println("Factorial of "+num+" is "+factorial);
        scan.close();
    }
}
