import java.util.Scanner;

public class PositiveNegativeOrZero {

    public static String postitiveNegativeOrZero(double number){
        if(number>0){
            return "Positive";
        }
        if(number<0){
            return "Negative";
        }
        return "Zero";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double number=scan.nextDouble();
        String postitiveNegativeOrZero = postitiveNegativeOrZero(number);
        System.out.println("The number "+number+" is a "+postitiveNegativeOrZero+" number.");
    }
}
