import java.util.Scanner;

public class SimpleInterest {

    public static double simpleInterest(double principal , double rate , double time){
        double interest = ( principal * rate* time ) / 100;
        return interest;
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter principal amount (in INR): ");
        double principal = scan .nextDouble();
        while(principal<0){
            System.out.print("Invalid principal amount! Enter again: ");
            principal = scan .nextDouble();
        }

        System.out.print("Enter % rate of interest: ");
        double rate = scan .nextDouble();
        while(rate<0){
            System.out.print("Invalid principal amount! Enter again: ");
            rate = scan .nextDouble();
        }

        System.out.print("Enter time (in years): ");
        double time = scan .nextDouble();
        while(time<0){
            System.out.print("Invalid principal amount! Enter again: ");
            time = scan .nextDouble();
        }

        double simpleInterest = simpleInterest(principal, rate, time);
        System.out.println("Simple Interest: "+simpleInterest);
    }
}
