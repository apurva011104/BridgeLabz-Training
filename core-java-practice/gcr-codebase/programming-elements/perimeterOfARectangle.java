import java.util.Scanner;

public class PerimeterOfARectangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter length of the rectangle: ");
        double length = scan.nextDouble();                 //Takes length input
        System.out.print("Enter breadth of the rectangle: ");
        double breadth = scan.nextDouble();                //Takes breadth input
        double perimeter = 2 * (length + breadth);         //Calculates perimeter of the rectangle
        System.out.println("Perimeter of the rectangle: " + perimeter);
    }
}
