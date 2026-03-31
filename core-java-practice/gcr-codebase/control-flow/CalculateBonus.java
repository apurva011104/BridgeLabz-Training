import java.util.Scanner;

public class CalculateBonus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the salary:");
        int salary = scan.nextInt();
        int yearsOfService = scan.nextInt();
        if (yearsOfService > 5) {
            double bonus = 0.05 * salary;
            System.out.println("Bonus: " + bonus);
        }
        else {
            System.out.println("No bonus");
        }
        scan.close();
    }
}
