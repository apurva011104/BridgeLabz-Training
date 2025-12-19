import java.util.Scanner;

public class SideOfASquare {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the perimeter of the square (in cms): ");
        double perimeter = scan.nextDouble();
        double side = perimeter / 4;
        System.out.println("The side of the square is: " + side + " cms whose perimeter is " + perimeter + " cms.");
        scan.close();
    }
    
}
