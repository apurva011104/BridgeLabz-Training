import java.util.Scanner;

public class FindYoungestAndTallest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Taking input for ages and heights of Amar, Akbar, and Anthony
        System.out.println("Enter Amar's age: ");
        int amarAge = scan.nextInt();
        System.out.println("Enter Akbar's age: ");
        int akbarAge = scan.nextInt();
        System.out.println("Enter Anthony's age: ");
        int anthonyAge = scan.nextInt();
        System.out.println("Enter Amar's height in cm: ");
        int amarHeight = scan.nextInt();   
        System.out.println("Enter Akbar's height in cm: ");
        int akbarHeight = scan.nextInt();
        System.out.println("Enter Anthony's height in cm: ");
        int anthonyHeight = scan.nextInt();

        if(amarAge < 0 || akbarAge < 0 || anthonyAge < 0 || amarHeight < 0 || akbarHeight < 0 || anthonyHeight < 0) {
            System.out.println("Please enter valid positive numbers for age and height.");
        } 
        else {
            // Finding the youngest
            if (amarAge < akbarAge && amarAge < anthonyAge) {
                System.out.println("Amar is the youngest.");
            } 
            else if (akbarAge < amarAge && akbarAge < anthonyAge) {
                System.out.println("Akbar is the youngest.");
            } 
            else if (anthonyAge < amarAge && anthonyAge < akbarAge) {
                System.out.println("Anthony is the youngest.");
            } 
            else {
                System.out.println("None of them is the youngest.");
            }
            
            // Finding the tallest
            if (amarHeight > akbarHeight && amarHeight > anthonyHeight) {
                System.out.println("Amar is the tallest.");
            }
            else if (akbarHeight > amarHeight && akbarHeight > anthonyHeight) {
                System.out.println("Akbar is the tallest.");
            }
            else if (anthonyHeight > amarHeight && anthonyHeight > akbarHeight) {
                System.out.println("Anthony is the tallest.");
            }
            else {
                System.out.println("None of them is the tallest.");
            }
        }
    }
}
