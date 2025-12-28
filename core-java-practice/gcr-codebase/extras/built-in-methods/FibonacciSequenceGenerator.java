
import java.util.Scanner;

public class FibonacciSequenceGenerator {

    //Method to take user input
    public static int takeUserInput(Scanner scan){
        System.out.print("Enter a non-negative integer: ");
        int num = scan.nextInt();
        while(num<0){
            System.out.print("Invalid integer! Please enter a non-negative integer: ");
            num=scan.nextInt();
        }
        return num;
    }

    //Method to generate fibonacci series
    public static long[] fibonacciSeries(int num){
        long[] series = new long[num+1];
        for(int i=0;i<=num;i++){
            if(i<2){
                series[i]=i;
            }
            else{
                series[i]=series[i-1]+series[i-2];
            }
        }
        return series;
    }

    //Method to display the series
    public static void displaySeries(long []series){
        System.out.println("Fibonacci series upto "+(series.length-1)+": ");
        for(int i=0 ; i<series.length ; i++){
            System.out.print(series[i]+", ");
        }
        System.out.print(series[series.length-1]);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = takeUserInput(scan);
        long[] fibonacciSeries = fibonacciSeries(num);
        displaySeries(fibonacciSeries);
        scan.close();

    }
}
