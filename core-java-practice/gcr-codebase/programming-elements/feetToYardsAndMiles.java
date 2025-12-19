import java.util.Scanner;

public class FeetToYardsAndMiles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the distance in feet: ");   
        double feet = scan.nextDouble();                       //Takes distance input in feet
        double yards = feet / 3;                               //Converts feet to yards
        double miles = yards / 1760;                            //Converts feet to miles
        System.out.println("The distance of " + feet + " feet is equal to " + yards + " yards or " + miles + " miles.");
        scan.close();
    }
}
