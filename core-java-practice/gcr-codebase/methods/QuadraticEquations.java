import java.util.Scanner;

public class QuadraticEquations {

    public static double[] findRoots(int a, int b, int c){
        int delta = (b*b) - (4*a*c);
        if(delta<0){
            return new double[0];
        }
        if(delta==0){
            double root = (-1*b)/(2*a);
            return new double[]{root};
        }
        double deltaRoot=Math.sqrt(delta);
        double root1= ((-1*b) + deltaRoot )/(2*a);
        double root2= ((-1*b) - deltaRoot )/(2*a);
        return new double[]{root1,root2};
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a: ");
        int a=scan.nextInt();
        System.out.print("Enter b: ");
        int b=scan.nextInt();
        System.out.print("Enter c: ");
        int c=scan.nextInt();

        double []roots =findRoots(a, b, c);
        if(roots.length==0){
            System.out.println("No real root exists.");
        }
        else if(roots.length==1){
            System.out.printf("Both roots are equal to %.3f",roots[0]);
        }
        else{
            System.out.printf("Roots are %.3f and %.3f",roots[0],roots[1]);
        }
    }
}
