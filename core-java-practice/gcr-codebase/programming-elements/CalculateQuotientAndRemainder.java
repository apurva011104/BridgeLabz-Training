import java.util.Scanner;

public class CalculateQuotientAndRemainder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the dividend: ");   
        int dividend = scan.nextInt();
        System.out.print("Enter the divisor: ");
        int divisor = scan.nextInt();
        int quotient = dividend / divisor;                     //Calculates quotient
        int remainder = dividend % divisor;                    //Calculates remainder   
        System.out.println("The quotient is: " + quotient + " and the remainder is: " + remainder + " when " + dividend + " is divided by " + divisor + ".");
        scan.close();   
    }
}
