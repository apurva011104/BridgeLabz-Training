import java.util.Scanner;

public class LineComparison {

    public static void start(){
        System.out.println("Welcome to Line Comparison Computation Program");
    }

    //Method to take point coordinates
    public static int[] takePointInput(Scanner scan){
        System.out.print("Enter x-coordinate of the point: ");
        int x = scan.nextInt();
        System.out.print("Enter y-coordinate of the point: ");
        int y = scan.nextInt();
        return new int[]{x,y};
    }

    //Method to calculate length of line
    public static double calculateLength(int []point1 , int []point2){
        double length = Math.sqrt( ( Math.pow(point2[0],2) - Math.pow(point1[0],2)) + ( Math.pow(point2[1],2) - Math.pow(point1[1],2) ));
        return Math.round(length*100.0)/100.0;
    }

    public static void main(String[] args) {
        start();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter point 1 coordinates: ");
        int []point1 = takePointInput(scan);
        System.out.println("Enter point 2 coordinates: ");
        int []point2 = takePointInput(scan);
        double length = calculateLength(point1, point2);
        System.out.printf("Length of the line: %.2f",length);
        scan.close();
    }
}
