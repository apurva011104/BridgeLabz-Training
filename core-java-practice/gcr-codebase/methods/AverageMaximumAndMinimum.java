import java.util.Arrays;
import java.util.Scanner;

public class AverageMaximumAndMinimum {

    public static int generateFourDigitNumber(){
        int number=0;
        for(int i=0;i<4;i++){
            int random=(int)(Math.random()*9);
            number=(number*10)+random;
        }
        return number;
    }
    
    public static int[] generateFourDigitNumberArrays(){
        int[] fourDigitNumbers = new int[5];
        for(int i=0;i<5;i++){
            fourDigitNumbers[i]=generateFourDigitNumber();
        }
        return fourDigitNumbers;
    }

    public static double findAverage(int []fourDigitNumbers){
        double sum=0;
        for(int i: fourDigitNumbers){
            sum+=i;
        }
        double average = sum / fourDigitNumbers.length;
        return average;
    }

    public static int findMaximum(int []fourDigitNumbers){
        int max=fourDigitNumbers[0];
        for(int i: fourDigitNumbers){
            max=Math.max(max, i);
        }
        return max;
    }

    public static int findMinimum(int []fourDigitNumbers){
        int min=fourDigitNumbers[0];
        for(int i: fourDigitNumbers){
            min=Math.min(min, i);
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int []fourDigitNumbers = generateFourDigitNumberArrays();
        System.out.println("Array: "+Arrays.toString(fourDigitNumbers));
        System.out.printf("Average: %.3f",findAverage(fourDigitNumbers));
        System.out.println("Maximum: "+findMaximum(fourDigitNumbers));
        System.out.println("Minimum: "+findMinimum(fourDigitNumbers));

    }

}
