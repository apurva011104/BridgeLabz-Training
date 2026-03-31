
import java.util.Scanner;

public class Program {

    private static double takeDoubleInput(Scanner scan){
        while (true) { 
            try {
                double input = Double.parseDouble(scan.nextLine().trim());
                return input;
            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter again:");
            }
        }
    }

    private static int takeIntegerInput(Scanner scan){
        while (true) { 
            try {
                int input = Integer.parseInt(scan.nextLine().trim());
                return input;
            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter again:");
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RobotHazardAuditor robotHazardAuditor = new RobotHazardAuditor();

        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = takeDoubleInput(scanner);

        System.out.println("Enter Worker Density (1 - 20):");
        int workerDensity = takeIntegerInput(scanner);

        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        String machineryState = scanner.nextLine().trim();

        try {
            double hazardRisk = robotHazardAuditor.calculateHazardRisk(armPrecision, workerDensity, machineryState);

            System.out.println("Robot Hazard Risk Score: "+hazardRisk);
        } 
        catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
