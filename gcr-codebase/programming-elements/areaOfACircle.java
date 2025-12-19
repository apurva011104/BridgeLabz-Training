import java.util.Scanner;

public class AreaOfACircle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter radius of the circle: ");   
        double radius = scan.nextDouble();                   //Takes radius input
        double area = Math.PI * radius * radius;            //Calculates area of the circle
        System.out.println("Area of the circle: "+area);
        scan.close();
    }
}
