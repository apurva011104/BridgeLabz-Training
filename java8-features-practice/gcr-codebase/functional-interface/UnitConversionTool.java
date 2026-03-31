public class UnitConversionTool {
    public static void main(String[] args) {
        
        double kilometers = 25.5;
        double kilograms = 48.4;

        System.out.println(kilometers+"kms = " + Convertor.convertKilometersToMiles(kilometers) + " miles");
        System.out.println(kilograms+" kgs = " + Convertor.convertKilogramsToPounds(kilograms)+ " lbs");
    }
}


interface Convertor{
    static double convertKilometersToMiles(double kilometers){
        if(kilometers<0){
            throw new IllegalArgumentException("Invalid length.");
        }
        return kilometers * 0.621;
    }

    static double convertKilogramsToPounds(double kilograms){
        if(kilograms<0){
            throw new IllegalArgumentException("Invalid weight.");
        }
        return kilograms * 2.205;
    }
}