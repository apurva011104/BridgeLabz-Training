import java.util.Scanner;

public class CheckPositiveNegativeOrZero {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scan.nextInt();
        if (num > 0) {
            System.out.println("Positive.");
        }
        else if (num < 0) {
            System.out.println("Negative.");
        }
        else {
            System.out.println("Zero.");
        }
        scan.close();
    }
}