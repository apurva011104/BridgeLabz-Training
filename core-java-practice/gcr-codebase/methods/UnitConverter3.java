public class UnitConverter3 {

    public static double convertFarhenheitIntoCelsius(double  farhenheit){
        return (farhenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusIntoFarhenheit(double celsius){
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsIntoKilograms(double pounds){
        return pounds * 0.453592;
    }

    public static double convertKilogramsIntoPounds(double kilograms){
        return kilograms * 2.20462;
    }

    public static double convertGallonsIntoLiters(double gallons){
        return gallons * 3.78541;
    }

    public static double convertLitersIntoGallons(double liters){
        return 0.264172 * liters;
    }

}
