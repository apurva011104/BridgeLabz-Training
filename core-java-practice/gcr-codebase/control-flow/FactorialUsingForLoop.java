import java.util.Scanner;

public class FactorialUsingForLoop {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int num= scan.nextInt();
        if(num<0){
            System.out.println("Factorial is not defined for negative numbers.");
        }
        else{
            int factorial=1;
            for(int i=num;i>0;i--){
                factorial *= i;
            }
            System.out.printf("The factorial of %d is %d.",num,factorial);
        }
    }
}
