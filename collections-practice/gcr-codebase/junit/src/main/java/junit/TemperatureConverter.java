package junit;

public class TemperatureConverter {
    
    public static double celsiusToFahrenheit(double celsius){
        double fahrenheit = (celsius * 9/5) + 32;
        return fahrenheit;
    }

    public static double fahrenheitToCelsius(double fahrenheit){
        double celsius = ((fahrenheit - 32) * 5)/9;
        return celsius;
    }
}
