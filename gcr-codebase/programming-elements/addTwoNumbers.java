import java.util.Scanner;

public class addTwoNumbers {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        System.out.print("Enter first number: ");
        int x=scan.nextInt();
        System.out.print("Enter second number: ");  
        int y=scan.nextInt();
        int sum=x+y;
        System.out.println("Sum of both numbers: "+sum);
        scan.close();
    }
}
