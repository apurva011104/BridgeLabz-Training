
import java.util.function.Predicate;

public class TemperatureAlertSystem {

    static private Predicate<Double> alert = (temperatureInCelsius) -> {
        return temperatureInCelsius > 50;
    };

    public static void checkTemperature(double temperatureInCelsius){
        if(alert.test(temperatureInCelsius)){
            System.out.println("Alert! Temperature crosses threshold!");
        }
        else{
            System.out.println("Normal temperature");
        }
    }
    public static void main(String[] args) {
        checkTemperature(25);
        checkTemperature(53);
    }
}
