import java.util.Scanner;

public class QuotientAndRemainder {
    
    public static int[] quotientAndRemainder(int dividend, int divisor){
        int quotient=dividend/divisor;
        int remainder=dividend%divisor;
        return new int[]{quotient,remainder};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter dividend: ");
        int dividend= scan.nextInt();
        System.out.print("Enter divisor: ");
        int divisor= scan.nextInt();
        if(divisor==0){
            System.out.println("Cannot be divided by zero");
        }
        else{
            int []quotientAndRemainder = quotientAndRemainder(dividend,divisor);
            System.out.println("Quotient: "+quotientAndRemainder[0]);
            System.out.println("Remainder: "+quotientAndRemainder[1]);
        }
        scan.close();
    }
}
