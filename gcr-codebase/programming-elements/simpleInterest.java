import java.util.Scanner;

public class simpleInterest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter principal amount: ");
        double principal = scan.nextDouble();               //Takes principal amount input
        System.out.print("Enter rate of interest: ");
        double rate = scan.nextDouble();                    //Takes rate of interest input
        System.out.print("Enter time in years: ");
        double time = scan.nextDouble();                    //Takes time input in years
        double simpleInterest = (principal * rate * time) / 100; //Calculates simple interest
        System.out.println("Simple Interest: " + simpleInterest);               
    }
}
