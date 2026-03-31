import java.util.Scanner;

public class GCDAndLCMCalculator {

    //Method to take user input
    public static int takeUserInput(Scanner scan){
        int num = scan.nextInt();
        while(num<=0){
            System.out.print("Invalid integer! Please enter a positive integer: ");
            num=scan.nextInt();
        }
        return num;
    }

    //Calculating gcd of two numbers
    public static int gcd(int num1, int num2){
        if(num2 == 0){
            return num1;
        }
        return gcd(num2 , num1%num2);
    }

    //Calculating lcm of two numbers
    public static long lcm(int num1, int num2){
        int gcd = gcd(num1,num2);
        long product = num1 * num2;
        return product/gcd;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num1 = takeUserInput(scan);
        System.out.print("Enter another positive integer: ");
        int num2 = takeUserInput(scan);

        int gcd = gcd(num1, num2);
        long lcm = lcm(num1, num2);

        System.out.printf("GCD of %d and %d is %d",num1,num2,gcd);
        System.out.printf("%nLCM of %d and %d is %d",num1,num2,lcm);

        scan.close();

    }
}
