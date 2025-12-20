import java.util.*;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scan.nextInt();
        int originalNum = num;

        //Counting the sum of digits
        int sumOfDigits = 0;
        while( num > 0 ){
            int digit = num % 10;
            sumOfDigits += digit;
            num /= 10;
        }

        //Checking if the original number is divisible by the sum of its digits
        if( originalNum % sumOfDigits == 0 ){
            System.out.println(originalNum + " is a Harshad number.");
        } else {
            System.out.println(originalNum + " is not a Harshad number.");
        }

        scan.close();
    }
}
