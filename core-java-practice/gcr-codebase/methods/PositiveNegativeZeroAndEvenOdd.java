import java.util.Arrays;
import java.util.Scanner;

public class PositiveNegativeZeroAndEvenOdd {

    public static boolean isPositive(int n){
        return n>0;
    }

    public static boolean isNegative(int n){
        return n<0;
    }

    public static boolean isEven(int n){
        return n%2==0;
    }

    public static String compare(int n1, int n2){
        if(n1>n2){
            return "greater than";
        }
        if(n1<n2){
            return "smaller than";
        }
        return "equal to";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int []numbers = new int[5];

        for(int i=0;i<5;i++){
            System.out.print("Enter an integer: ");
            numbers[i]=scan.nextInt();
        }

        System.out.println("Array: "+Arrays.toString(numbers));
        for(int n: numbers){
            System.out.print("Number "+n+" is ");
            if(isPositive(n)){
                if(isEven(n)){
                    System.out.println("even positive");
                }
                else{
                    System.out.println("odd positive");
                }
            }
            else if (isNegative(n)) {
                System.out.println("negative");
            }
            else{
                System.out.println("zero");
            }
        }
        String compare = compare(numbers[0], numbers[4]);
        System.out.println("First element "+numbers[0]+" is "+compare+" last element "+numbers[4]);
    }
}
