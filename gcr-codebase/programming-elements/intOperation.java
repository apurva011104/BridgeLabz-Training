import java.util.Scanner;

public class intOperation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter value of a:");
        int a=scan.nextInt();
        System.out.print("Enter value of b:");
        int b=scan.nextInt();
        System.out.print("Enter value of c:");
        int c=scan.nextInt();
        int result1 = a + b * c;
        int result2 = a * b + c;
        int result3 = c + a / b;
        int result4 = a % b + c;
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);      
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);
        scan.close();
    }
}
