
import java.util.Arrays;

public class CollinearPoints {

    public static double calculateSlope( int[] point1 , int[] point2){
        double slope = (point2[1]-point1[1]) / (point2[0]-point1[0]);
        slope = Math.round(slope * 100.0) / 100.0;
        return slope;
    }

    public static int  calculateDeterminant(int [][]matrix){
        int determinant = (matrix[0][0] * matrix [1][1]) - (matrix[0][1] * matrix[1][0]);
        return determinant;
    }

    public static boolean collinearPointsUsingSlopeFormula( int[] point1 , int[] point2 , int[] point3 ){
        double slope12 = calculateSlope(point1, point2);
        double slope23 = calculateSlope(point2, point3);
        double slope13 = calculateSlope(point1, point2);
        if(slope12==slope23 || slope12==slope13 || slope13==slope23){
            return true;
        }
        return false;
    }

    public static boolean collinearPointsUsingTriangleFormula( int[] point1 , int[] point2 , int[] point3 ){
        int [][]matrix = new int[2][2];
        matrix[0][0] = point1[0]-point2[0];
        matrix[0][1] = point2[0]-point3[0];
        matrix[1][0] = point1[1]-point2[1];
        matrix[1][1] = point2[1]-point3[1];
        int determinant = calculateDeterminant(matrix);
        return determinant==0;
    }


    public static void main(String[] args) {
        int[] pointA = {2,4};
        int[] pointB = {4,6};
        int[] pointC = {6,8};

        System.out.println("Point A: "+Arrays.toString(pointA));
        System.out.println("Point B: "+Arrays.toString(pointB));
        System.out.println("Point C: "+Arrays.toString(pointC));
        System.out.println("Are points collinear using slope formula?: "+collinearPointsUsingSlopeFormula(pointA, pointB, pointC));
        System.out.println("Are points collinear using triangle formula?: "+collinearPointsUsingTriangleFormula(pointA, pointB, pointC));
    }
}
