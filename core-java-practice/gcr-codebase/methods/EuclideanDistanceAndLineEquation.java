import java.util.Arrays;
import java.util.Scanner;

public class EuclideanDistanceAndLineEquation {

    //Calculating slope. (slope= (y2-y1)/(x2-x1))
    public static double calculateSlope( int[] point1 , int[] point2){
        double slope = (point2[1]-point1[1]) / (point2[0]-point1[0]);
        slope = Math.round(slope * 100.0) / 100.0;
        return slope;
    }
    
    //Calculating y-Intercept ( y-intercept = y1-(slope*x1) )
    public static double yIntercept(int []point1, int []point2){
        double slope = calculateSlope(point1, point2);
        double yIntercept = point1[1] - (slope * point1[0]);
        return yIntercept;
    }

    //Calculating euclidean distance
    public static double euclideanDistance(int []point1 , int []point2){
        double distance = Math.sqrt( Math.pow((point2[0]-point1[0]),2) + Math.pow((point2[1]-point1[1]),2) );
        return distance;
    }

    //Finding line slope and y-intercept
    public static double[] lineSlopeAndYIntercept(int[] point1 , int[] point2){
        double slope = calculateSlope(point1, point2);
        double yIntercept = yIntercept(point1, point2);
        return new double[]{slope,yIntercept};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int [][]points = new int[2][2];
        for(int i=0 ; i<2 ; i++){
            System.out.print("Enter x-coordinate of point "+(i+1)+": ");
            points[i][0]=scan.nextInt();
            System.out.print("Enter y-coordinate of point "+(i+1)+": ");
            points[i][1]=scan.nextInt();
        }

        double euclideanDistance = euclideanDistance(points[0], points[1]);
        double []lineSlopeAndYIntercept = lineSlopeAndYIntercept(points[0], points[1]);

        System.out.println("Point 1: "+Arrays.toString(points[0]));
        System.out.println("Point 2: "+Arrays.toString(points[1]));
        System.out.printf("Euclidean distance: %.2f",euclideanDistance);
        System.out.println();
        System.out.printf("Equation of line: y = %.2f"+"x + %.2f",lineSlopeAndYIntercept[0],lineSlopeAndYIntercept[1]);
    }
}
