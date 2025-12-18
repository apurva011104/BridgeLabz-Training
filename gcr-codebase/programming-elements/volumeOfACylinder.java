import java.util.Scanner;

public class volumeOfACylinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter radius of the cylinder: "); 
        double radius = scan.nextDouble();                   //Takes radius input
        System.out.print("Enter height of the cylinder: ");
        double height = scan.nextDouble();                   //Takes height input
        double volume = Math.PI * radius * radius * height; //Calculates volume of the cylinder
        System.out.println("Volume of the cylinder: "+volume);
        scan.close();
    }
    
}
