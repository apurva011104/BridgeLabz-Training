
import java.util.ArrayList;
import java.util.Scanner;

public class TemperatureAnalyzer {

    float[][] temperatureArray;

    public TemperatureAnalyzer() {
        this.temperatureArray = new float[7][24];
    }

    //Method to find average temperature per day
    public float calculateAverageTemperature( float[] perDayTemperature){
        float total = 0.0f;

        for(float temperature: perDayTemperature){
            total+=temperature;
        }

        return total/(24.0f);
    }
    
    //Method to store average temperature per day in array
    public float[] averageTemperaturePerDay(){
        float[] averageTemperaturePerDay = new float[7];

        for(int i=0; i<7;i++){
            averageTemperaturePerDay[i] = calculateAverageTemperature(temperatureArray[i]);
        }

        return averageTemperaturePerDay;
    }

    //Method to find coldest days
    public ArrayList<Integer>  coldestDays(){

        float[] averageTemperaturePerDay = averageTemperaturePerDay();

        ArrayList<Integer> coldestDays = new ArrayList<>();

        float minTemperature = averageTemperaturePerDay[0];

        for(int i=0; i<7 ; i++){
            if(minTemperature>averageTemperaturePerDay[i]){
                minTemperature=averageTemperaturePerDay[i];
                coldestDays=new ArrayList<>();
            }
            if(minTemperature==averageTemperaturePerDay[i]){
                coldestDays.add(i+1);
            }
        }
        return coldestDays;
    }

    //Method to find hottest days
    public ArrayList<Integer>  hottestDays(){

        float[] averageTemperaturePerDay = averageTemperaturePerDay();

        ArrayList<Integer> hottestDays = new ArrayList<>();

        float maxTemperature = averageTemperaturePerDay[0];

        for(int i=0; i<7 ; i++){
            if(maxTemperature<averageTemperaturePerDay[i]){
                maxTemperature=averageTemperaturePerDay[i];
                hottestDays=new ArrayList<>();
            }
            if(maxTemperature==averageTemperaturePerDay[i]){
                hottestDays.add(i+1);
            }
        }
        return hottestDays;
    }

    //Method too take input
    public void takeWeeklyInput(Scanner scan){

        for(int i=0 ; i<7; i++){
            System.out.println("Day "+(i+1)+": ");
            for(int j=0 ; j<24 ; j++){
                System.out.print("Enter temperature at hour "+(j+1)+" (in Celsius): ");
                temperatureArray[i][j]=scan.nextFloat(); 
            }
        }
    }

    //Method to display average temperature per day
    public void displayAverageTemperaturePerDay(int weekNumber){

        float[] averageTemperaturePerDay = averageTemperaturePerDay();

        System.out.println("Week "+weekNumber+" average temperature per day (in Celsius): ");
        for (int i = 0; i < 7; i++) {
            System.out.printf("Day %d: %.2f",(i+1),averageTemperaturePerDay[i]);
        }

    }

    public void displayHottestAndColdestDays(int weekNumber){

        ArrayList<Integer> hottestDays = hottestDays();
        ArrayList<Integer> coldestDays = coldestDays();

        System.out.print("Week "+weekNumber+" hottest day(s): ");
        for(int day: hottestDays){
            System.out.print(day+" ");
        }

        System.out.println();
        System.out.print("Week "+weekNumber+" coldest day(s): ");
        for(int day: coldestDays){
            System.out.print(day+" ");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TemperatureAnalyzer week1 = new TemperatureAnalyzer();
        week1.takeWeeklyInput(scan);

        week1.displayAverageTemperaturePerDay(1);
        week1.displayHottestAndColdestDays(1);
        scan.close();
    }
}
