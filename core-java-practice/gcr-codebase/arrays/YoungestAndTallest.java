
import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int []heights=new int[3];
        int []age=new int[3];

        System.out.println("Enter Amar's age: ");
        age[0] = scan.nextInt();
        System.out.println("Enter Akbar's age: ");
        age[1] = scan.nextInt();
        System.out.println("Enter Anthony's age: ");
        age[2]= scan.nextInt();
        System.out.println("Enter Amar's height in cm: ");
        heights[0] = scan.nextInt();   
        System.out.println("Enter Akbar's height in cm: ");
        heights[1] = scan.nextInt();
        System.out.println("Enter Anthony's height in cm: ");
        heights[2] = scan.nextInt();

        if(age[0] < 0 || age[1] < 0 || age[2] < 0 || heights[0] < 0 || heights[1] < 0 || heights[2] < 0) {
            System.out.println("Please enter valid positive numbers for age and height.");
        } 
        else {
            // Finding the youngest
            if (age[0] < age[1] && age[0] < age[2]) {
                System.out.println("Amar is the youngest.");
            } 
            else if (age[1] < age[0] && age[1] < age[2]) {
                System.out.println("Akbar is the youngest.");
            } 
            else if (age[2] < age[0] && age[2] < age[1]) {
                System.out.println("Anthony is the youngest.");
            } 
            else {
                System.out.println("None of them is the youngest.");
            }
            
            // Finding the tallest
            if (heights[0] > heights[1] && heights[0] > heights[2]) {
                System.out.println("Amar is the tallest.");
            }
            else if (heights[1] > heights[0] && heights[1] > heights[2]) {
                System.out.println("Akbar is the tallest.");
            }
            else if (heights[2] > heights[0] && heights[2] > heights[1]) {
                System.out.println("Anthony is the tallest.");
            }
            else {
                System.out.println("None of them is the tallest.");
            }
        }
        scan.close();
    }
}
