import java.util.Scanner;

public class AbundantNumber {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scan.nextInt();

        //Calculating the sum of proper divisors
        int sumOfDivisors = 0;
        for(int i = 1 ; i <= num/2 ; i++){
            sumOfDivisors += ((num % i == 0) ? i : 0);
        }

        //Checking if the number is greater than the sum of its proper divisors
        if(sumOfDivisors > num){
            System.out.println(num + " is an Abundant Number");
        } 
        else {
            System.out.println(num + " is not an Abundant Number");
        }
    }
}
