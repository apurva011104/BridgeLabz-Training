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

    //Method to check compare length of the line
    public static int compareLengths(Double length1 , Double length2){
        int compare =  length1.compareTo(length2);      //Return positive integer if length1 greater length2 , negative integer if length1 smaller than length 2 and zero if both lengths are equal
        return compare>0 ? 1 : ( compare<0 ? -1 : 0 );
    }

    //Method to get comparison : equal, greater or lesser
    public static String compareLineLengths(Double length1 , Double length2){
        int compare = compareLengths(length1, length2);
        
        switch (compare) {
            case 1:
                return "greater";
            case -1:
                return "lesser";
            default:
                return "equal";
        }
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

        String lineComparison = compareLineLengths(length1, length2);

        //Displaying results
        System.out.printf("Length of the line1: %.2f %n",length1);
        System.out.printf("Length of the line2: %.2f %n",length2);
        System.out.println("Line 1 is "+lineComparison+" to Line 2");
        scan.close();
    }
}
