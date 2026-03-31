
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static int takeNumberOfVesselsInput(Scanner scanner){
        while (true) { 
            try {
                int n = scanner.nextInt();
                if(n<0){
                    System.out.println("Invalid number of vessels. Enter again: ");
                    continue;
                }
                scanner.nextLine();
                return n;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Invalid input for number of vessels. Enter again: ");
            }
        }
    }

    public static Vessel createVessel(String input){
        input = input.trim();
        input = input.replaceAll("\\s+:\\s+", ":");
        if(!input.matches("[a-zA-Z0-9]+:[a-zA-Z]+(\\s[a-zA-Z]+)*:[0-9]+(.[0-9]+)?:[a-zA-Z]+(\\s[a-zA-Z]+)*")){
            throw new IllegalArgumentException();
        }
        String[] properties = input.split(":");
        Vessel vessel = new Vessel(properties[0],properties[1],Double.parseDouble(properties[2]), properties[3]);
        return vessel;
    }

    private static String vesselDetails(Vessel vessel){
        return String.format("%s | %s | %s | %.1f knots" , vessel.getVesselId(), vessel.getVesselName(), vessel.getVesselType(), vessel.getAverageSpeed());
    }

    public static void main(String[] args) {
        final Scanner SCANNER = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();

        System.out.println("Enter the number of vessels to be added");
        int n = takeNumberOfVesselsInput(SCANNER);

        System.out.println("Enter vessel details");
        for(int i=0 ; i<n ;i++){
            try {
                String input = SCANNER.nextLine();
                Vessel vessel = createVessel(input);
                vesselUtil.addVesselPerformance(vessel);
            } 
            catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Enter details again:");
                i--;
            }
        }

        System.out.println("Enter the Vessel Id to check speed");
        String vesselId = SCANNER.nextLine().trim();
        Vessel vessel = vesselUtil.getVesselById(vesselId);
        if(vessel==null){
            System.out.println("Vessel Id " + vesselId + " not found");
        }
        else{
            System.out.println(vesselDetails(vessel));
        }

        List<Vessel> highPerformanceVessels = vesselUtil.getHighPerformanceVessels();
        System.out.println("High performance vessels are");
        for(Vessel v: highPerformanceVessels){
            System.out.println(vesselDetails(v));
        }


    }
}
