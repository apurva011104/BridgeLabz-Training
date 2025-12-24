import java.util.Scanner;

public class TrigonometricFunctions {

    public static double[] trigonometricFunctions(double angle){
        double angleInRadians = Math.toRadians(angle); 
        double sine = Math.sin(angleInRadians);
        double cosine = Math.cos(angleInRadians);
        double tangent = Math.tan(angleInRadians);
        return new double[]{sine,cosine,tangent};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter angle (in degrees): ");
        double angle=scan.nextDouble();

        double []trigonometricFunctions = trigonometricFunctions(angle);

        System.out.printf("Sine: %.3f",trigonometricFunctions[0]);
        System.out.println();
        System.out.printf("Cosine: %.3f",trigonometricFunctions[1]);
        System.out.println();
        System.out.printf("Tangent: %.3f",trigonometricFunctions[2]);
        System.out.println();
    }
}
