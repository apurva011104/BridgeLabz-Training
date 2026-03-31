import java.util.Scanner;

public class Circle {
    
    double radius;

    //Default constructor
    Circle() {
        this(0.5);      //Constructor chaining
    }

    //Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Circle circle1 = new Circle();
        
        System.out.print("Enter radius to create new circle object: ");
        double radius2 = scan.nextDouble();
        Circle circle2 = new Circle(radius2);

        System.out.println("Default circle's radius: "+circle1.radius);
        System.out.println("User created circle's radius: "+circle2.radius);

        scan.close();
    }
}
