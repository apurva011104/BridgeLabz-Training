import java.util.ArrayList;
import java.util.Scanner;

public class NumberChecker5 {

    //Store digits of a number in a digits array
    public static int[] digitsArray(int num){
        if(num==0){
            return new int[]{0};
        }
        ArrayList<Integer> digits = new ArrayList<>();
        while(num>0){
            digits.add(num%10);
            num/=10;
        }

        int[] digitsArray=new int[digits.size()];
        for(int i=0 ; i<digits.size() ; i++){
            digitsArray[digits.size()-1-i] = digits.get(i);
        }

        return digitsArray;
    }

    //Storing proper divisors of a number in an array
    public static int[] properDivisors(int num){
        ArrayList<Integer> properDivisors = new ArrayList<>();
        for(int i=1;i<=num/2;i++){
            if(num%i==0){
                properDivisors.add(i);
            }
        }
        int[] properDivisorsArray = new int[properDivisors.size()];
        for(int i=0 ; i<properDivisors.size();i++){
            properDivisorsArray[i]=properDivisors.get(i);
        }
        return properDivisorsArray;
    }

    //Sum of the elements of an array
    public static int sumOfArrayElements(int[] array){
        int sum = 0;
        for(int i: array){
            sum+=i;
        }
        return sum;
    }

    //Factorial of a number
    public static int factorial(int num){
        int factorial=1;
        for(int i=1;i<=num;i++){
            factorial*=i;
        }
        return factorial;
    }

    //Check if a number is perfect number or not
    public static boolean isPerfectNumber(int num){
        int[] properDivisors = properDivisors(num);
        int sumOfProperDivisors = sumOfArrayElements(properDivisors);
        return num==sumOfProperDivisors;
    }

    //Check if a number is abundant number or not
    public static boolean isAbundantNumber(int num){
        int[] properDivisors = properDivisors(num);
        int sumOfProperDivisors = sumOfArrayElements(properDivisors);
        return num<sumOfProperDivisors;
    }

    //Check if a number is deficient number or not
    public static boolean isDeficientNumber(int num){
        int[] properDivisors = properDivisors(num);
        int sumOfProperDivisors = sumOfArrayElements(properDivisors);
        return num>sumOfProperDivisors;
    }

    //Check if a number is strong number or not
    public static boolean isStrongNumber(int num){
        int[] digitsArray = digitsArray(num);
        int sum = 0;
        for(int i: digitsArray){
            sum+=factorial(i);
        }
        return num==sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter an integer n (0<=n): ");
        int num=scan.nextInt();
        while(num<0){
            System.out.print("Please enter a number greater than or equal to 0: ");
            num=scan.nextInt();
        }

        //Displaying results
        System.out.println("Is perfect number?: "+isPerfectNumber(num));
        System.out.println("Is abundant number?: "+isAbundantNumber(num));
        System.out.println("Is deficient number?: "+isDeficientNumber(num));
        System.out.println("Is strong number?: "+isStrongNumber(num));
        scan.close();
    }
}
