
import java.util.Scanner;

public class UserInterface {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightUtil flightUtil = new FlightUtil(); 
        try {
            System.out.println("Enter flight details");
            String input = scanner.nextLine().trim();
            input = input.replaceAll("\\s+", " ");
            String[] attributes = input.split("\\s*:\\s*");

            if(attributes.length!=4){
                throw new IllegalArgumentException("Invalid number of attributes");
            }

            String flightNumber = attributes[0];
            flightUtil.validateFlightNumber(flightNumber);

            String flightName = attributes[1];
            flightUtil.validateFlightName(flightName);

            int passengerCount = Integer.parseInt(attributes[2]);
            flightUtil.validatePassengerCount(passengerCount, flightName);

            double currentFuelLevel = Double.parseDouble(attributes[3]);
            double fuelToFill = flightUtil.calculateFuelToFillTank(flightName, currentFuelLevel);

            System.out.println("Fuel required to fill the tank: "+fuelToFill+" liters");

        }
        catch (InvalidFlightException e) {
            System.out.println(e.getMessage());
        }
        catch(NumberFormatException e){
            System.out.println("Invalid passenger capacity or fuel level.");
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
