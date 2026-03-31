import java.util.Scanner;

public class AreaOfATriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the base of the triangle (in cms): ");   
        double base = scan.nextDouble();                       //Takes base input
        System.out.print("Enter the height of the triangle (in cms): ");
        double height = scan.nextDouble();                     //Takes height input 
        double areaInCms = 0.5 * base * height;                     //Calculates area of the triangle
        double areaInInches = areaInCms / Math.pow(2.54, 2);                             //Converts area from cms to inches
        System.out.println("The area of the triangle in square centimeters is "+ areaInCms +"while in square inches is" + areaInInches + ".");
        scan.close();
    }
    
}
