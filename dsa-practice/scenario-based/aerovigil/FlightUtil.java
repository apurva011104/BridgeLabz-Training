
public class FlightUtil {

    private enum Flight{
        SpiceJet("SpiceJet",396,200000),
        Vistara("Vistara",615,300000),
        IndiGo("IndiGo",230,250000),
        AirArabia("Air Arabia",130,150000);

        private String name;
        private int passengerMaximumCapacity;
        private double fuelTankCapacityInLiters;

        private Flight( String name, int passengerMaximumCapacity, double fuelTankCapacityInLiters) {
            this.name= name;
            this.passengerMaximumCapacity = passengerMaximumCapacity;
            this.fuelTankCapacityInLiters = fuelTankCapacityInLiters;
        }

        
        public int getPassengerMaximumCapacity() {
            return passengerMaximumCapacity;
        }

        public double getFuelTankCapacityInLiters() {
            return fuelTankCapacityInLiters;
        }

        public String getName() {
            return name;
        }

    }
    

    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException{
        boolean isValid = flightNumber.matches("FL-[1-9][0-9]{3}");
        if(!isValid){
            throw new InvalidFlightException("The flight number "+ flightNumber+" is invalid");
        }
        return true;
    }

    public boolean validateFlightName(String flightName) throws InvalidFlightException{
        boolean isValid = false;
        String fn = flightName.replaceAll("\\s+", " ");
        for(Flight flight: Flight.values()){
            if(fn.equalsIgnoreCase(flight.getName())){
                isValid=true;
                break;
            }
        }
        if(!isValid){
            throw new InvalidFlightException("The flight name "+ flightName+" is invalid");
        }
        return true;
    }

    public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException{
        validateFlightName(flightName);
        String fn = flightName.replaceAll("\\s+", " ");
        int maximumPassengerCount = 0;
        for(Flight flight: Flight.values()){
            if(fn.equalsIgnoreCase(flight.getName())){
                maximumPassengerCount = flight.getPassengerMaximumCapacity();
                break;
            }
        }
        if(passengerCount<=0 || passengerCount>maximumPassengerCount){
            throw new InvalidFlightException("The passenger count "+ passengerCount+" is invalid for "+flightName);
        }
        return true;
    }

    public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException{
        validateFlightName(flightName);
        String fn = flightName.replaceAll("\\s+", " ");

        double fuelTankCapacityInLiters =0;
        for(Flight flight: Flight.values()){
            if(fn.equalsIgnoreCase(flight.getName())){
                fuelTankCapacityInLiters = flight.getFuelTankCapacityInLiters();
                break;
            }
        }

        if(currentFuelLevel<0 || fuelTankCapacityInLiters<currentFuelLevel){
            throw new InvalidFlightException("Invalid fuel level for "+flightName);
        }

        return fuelTankCapacityInLiters - currentFuelLevel;
    }
}
