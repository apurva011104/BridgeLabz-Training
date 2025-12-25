import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker3 {

    //Count digits in the number
    public static int countDigits(int num){
        if(num==0)      return 1;
        int count=0;
        while(num>0){
            count++;
            num/=10;
        }
        return count;
    }

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

    //Reversing digits array
    public static int[] reverseDigitsArray(int num){
        int []digitsArray = digitsArray(num);
        int []reversedArray = new int[digitsArray.length];

        for(int i=0;i<digitsArray.length ; i++){
            reversedArray[digitsArray.length-1-i]=digitsArray[i];
        }

        return reversedArray;
    }

    //Comparing two arrays
    public static boolean compareArrays(int[] array1 , int[] array2){
        if(array1.length!=array2.length){
            return false;
        }

        for(int i=0 ; i<array2.length ; i++){
            if(array1[i]!=array2[i]){
                return false;
            }
        }
        return true;
    }

    //Check if a number is palindrome number or not
    public static boolean isPalindrome(int num){
        int []digitsArray = digitsArray(num);
        int []reversedDigitsArray = reverseDigitsArray(num);
        return compareArrays(digitsArray, reversedDigitsArray);
    }

    //Check if a number is duck number or not
    public static boolean isDuckNumber(int num){
        if(num<=0){
            return false;
        }
        int []digitsArray = digitsArray(num);
        for(int i: digitsArray){
            if(i==0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter an integer n (0<=n): ");
        int num=scan.nextInt();
        while(num<0){
            System.out.print("Please enter a number greater than or equal to 0: ");
            num=scan.nextInt();
        }

        //Displaying number of digits
        System.out.println("Number Of digits: "+countDigits(num));

        //Displaying digits in the number by storing it in array
        int []digitsArray = digitsArray(num);
        System.out.println("Digits array: "+Arrays.toString(digitsArray));

        //Displaying reversed digits array
        int []reversedDigitsArray = reverseDigitsArray(num);
        System.out.println("Reversed digits array: "+Arrays.toString(reversedDigitsArray));

        //Displaying the results after comparing both array
        System.out.println("Are both arrays equal? "+compareArrays(digitsArray, reversedDigitsArray));


        //Displaying if number is a palindrome number
        System.out.println("Is palindrome number? "+isPalindrome(num));

        //Displaying if number is a duck number
        System.out.println("Is duck number? "+isDuckNumber(num));
    }
}
