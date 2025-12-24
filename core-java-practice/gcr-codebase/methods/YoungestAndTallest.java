import java.util.Scanner;

public class YoungestAndTallest {

    public static String youngest(int []age){
        if(age[0]<age[1] && age[0]<age[2]){
            return "Amar";
        }
        if(age[1]<age[0] && age[1]<age[2]){
            return "Akbar";
        }
        if(age[2]<age[0] && age[2]<age[1]){
            return "Anthony";
        }
        return "No one";
    }

    public static String tallest(double []heights){
        if(heights[0]<heights[1] && heights[0]<heights[2]){
            return "Amar";
        }
        if(heights[1]<heights[0] && heights[1]<heights[2]){
            return "Akbar";
        }
        if(heights[2]<heights[0] && heights[2]<heights[1]){
            return "Anthony";
        }
        return "No one";
    }
    
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int []age=new int[3];
        System.out.print("Enter Amar's age: ");
        age[0] = scan.nextInt();
        System.out.print("Enter Akbar's age: ");
        age[1] = scan.nextInt();
        System.out.print("Enter Anthony's age: ");
        age[2]= scan.nextInt();
        
        double []heights=new double[3];
        System.out.print("Enter Amar's height in cm: ");
        heights[0] = scan.nextDouble();   
        System.out.print("Enter Akbar's height in cm: ");
        heights[1] = scan.nextDouble();
        System.out.print("Enter Anthony's height in cm: ");
        heights[2] = scan.nextDouble();

        System.out.println("Youngest: "+youngest(age));
        System.out.println("Tallest: "+tallest(heights));

        scan.close();
    }
}
