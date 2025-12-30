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

    //Method to take line points coordinates
    public static int[][] takeLinePointsInput(Scanner scan){
        System.out.println("Enter point 1 coordinates: ");
        int []point1 = takePointInput(scan);
        System.out.println("Enter point 2 coordinates: ");
        int []point2 = takePointInput(scan);
        return new int[][]{point1,point2};
    }

    //Method to calculate length of line
    public static Double calculateLength(int [][]linePoints){
        int []point1 = linePoints[0];
        int []point2 = linePoints[1];
        Double length = Math.sqrt( ( Math.pow(point2[0] - point1[0],2)) + ( Math.pow(point2[1] - point1[1],2) ));
        return Math.round(length*100.0)/100.0;
    }

    //Method to check equality of length of the line
    public static boolean checkLineEquality(Double length1 , Double length2){
        return length1.equals(length2);
    }

    public static void main(String[] args) {
        start();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter line1 points coordinates: ");
        int [][]line1 = takeLinePointsInput(scan);
        System.out.println("Enter line2 points coordinates: ");
        int [][]line2 = takeLinePointsInput(scan);

        Double length1 = calculateLength(line1);
        Double length2 = calculateLength(line2);

        boolean isEqual = checkLineEquality(length1, length2);

        System.out.printf("Length of the line1: %.2f %n",length1);
        System.out.printf("Length of the line2: %.2f %n",length2);
        System.out.println("Is line1 and line2 equal?: "+isEqual);
        scan.close();
    }
}
