//Demonstrating polymorphism

public class NormalPricing implements FareCalculator {
    @Override
    public double calculateFare(double distance,double rideTypeMultiplier) {
        return distance * 15.0 * rideTypeMultiplier;
    }
}
