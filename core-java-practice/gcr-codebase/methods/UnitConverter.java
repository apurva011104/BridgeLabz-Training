import java.util.Scanner;

public class UnitConverter {

    public static double convertKilometersIntoMiles(double km){
        return km*0.621371;
    }

    public static double convertMilesIntoKilometers(double miles){
        return miles*1.60934;
    }

    public static double convertFeetsIntoMeters(double feets){
        return 0.3408*feets;
    }

    public static double convertMetersIntoFeets(double meters){
        return 3.28084*meters;
    }
}
