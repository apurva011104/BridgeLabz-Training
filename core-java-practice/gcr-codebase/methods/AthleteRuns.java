import java.util.Scanner;

public class AthleteRuns {

    public static boolean isValidTriangle(double []sideLength){
        if( (sideLength[0]>=(sideLength[1]+sideLength[2])) || (sideLength[1]>=(sideLength[0]+sideLength[2]))  || (sideLength[2]>=(sideLength[1]+sideLength[0])) ){
            return false;
        }
        return true;
    }

    public static double[] takeSidesInput(Scanner scan){
        double []sideLength=new double[3];
        for( int i=0 ; i<3 ; i++){
            System.out.print("Enter length of side "+(i+1)+" of triangular park (in meters): ");
            sideLength[i]=scan.nextDouble();
            while(sideLength[i]<=0){
                System.out.print("Invalid length! Enter again: ");
                sideLength[i]=scan.nextDouble();
            }
        }
        return sideLength;
    }

    public static double perimeter(double []sideLength){
        double perimeter = 0;
        for(int i=0; i<3; i++){
            perimeter+=sideLength[i];
        }
        return perimeter;
    }

    public static double calculateRounds(double []sideLength){
        double perimeter = perimeter(sideLength);
        double rounds=5000/perimeter;
        return rounds;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter dimensions of triangular park.");
        double []sideLength=takeSidesInput(scan);
        while (!isValidTriangle(sideLength)) { 
            System.out.println("Invalid triangle! Enter dimensions again.");
            sideLength=takeSidesInput(scan);
        }

        double rounds = calculateRounds(sideLength);
        System.out.println("Distance covered in one round: "+perimeter(sideLength));
        System.out.printf("Rounds athlete has to run to cover 5km: %.2f",rounds);

    }
}
