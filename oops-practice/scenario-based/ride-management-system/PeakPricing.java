//Demonstrating polymorphism

public class PeakPricing implements FareCalculator {

    @Override
    public double calculateFare(double distance , double rideTypeMultiplier) {
        return distance * 20 * rideTypeMultiplier;
    }
}
