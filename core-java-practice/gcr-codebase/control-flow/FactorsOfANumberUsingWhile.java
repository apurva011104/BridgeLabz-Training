import java.util.Scanner;

public class FactorsOfANumberUsingWhile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = scan.nextInt();
        if (num <= 0) {
            System.out.println("Not a positive integer.");
            return;
        }
        System.out.print("Factors of " + num + " are:");
        int i = 1;
        while (i <= num) {
            if (num % i == 0) {
                System.out.print(" "+i);
            }
            i++;
        }
        scan.close();
    }
}
