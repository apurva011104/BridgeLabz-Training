import java.util.Scanner;

public class FactorialUsingWhileLoop {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int num= scan.nextInt();
        if(num<0){
            System.out.println("Factorial is not defined for negative numbers.");
        }
        else{
            int factorial=1;
            int temp=num;
            while(temp>0){
                factorial *= temp;
                temp--;
            }
            System.out.printf("The factorial of %d is %d.",num,factorial);
        }
    }
}
