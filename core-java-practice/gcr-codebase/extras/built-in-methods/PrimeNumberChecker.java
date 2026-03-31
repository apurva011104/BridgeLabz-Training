import java.util.Scanner;

public class PrimeNumberChecker {

    //Method to take user input
    public static int takeUserInput(Scanner scan){
        System.out.print("Enter a positive integer: ");
        int num = scan.nextInt();
        while(num<=0){
            System.out.print("Invalid integer! Please enter a positive integer: ");
            num=scan.nextInt();
        }
        return num;
    }

    //Method to check whether the number is prime or not
    public static boolean isPrime(int num){
        if(num==1 || (num!=2 && num%2==0)){
            return false;
        }
        for(int i=3; i<=num/2; i+=2){
            if( num%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = takeUserInput(scan);
        boolean isPrime = isPrime(num);
        System.out.println("Is "+num+" a prime number?: "+isPrime);
        scan.close();
    }
}
