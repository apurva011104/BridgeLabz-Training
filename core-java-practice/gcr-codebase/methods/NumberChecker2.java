import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker2 {
    
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

    //Sum of digits of the number
    public static int sumOfDigits(int num){
        int []digitsArray= digitsArray(num);
        int sum=0;
        for(int i:digitsArray){
            sum+=i;
        }
        return sum;
    }

    //Sum of squares of the digits of the number
    public static int sumOfSquaresOfDigits(int num){
        int []digitsArray= digitsArray(num);
        int sum=0;
        for(int i:digitsArray){
            sum+=(int)Math.pow(i,2);
        }
        return sum;
    }

    //Check if a number is harshad number or not
    public static boolean isHarshadNumber(int num){
        int []digitsArray = digitsArray(num);
        int sum = sumOfDigits(num);
        return num%sum==0;
    }

    //Frequency of each digit
    public static int[][] frequencyOfDigits(int num){
        int []digitsArray = digitsArray(num);
        int [][]frequency = new int[digitsArray.length][2];
        int []freq = new int[10];
        for(int i: digitsArray){
            freq[i]++;
        }
        for(int i=0 ; i<digitsArray.length ; i++){
            frequency[i][0]=digitsArray[i];
            frequency[i][1]=freq[digitsArray[i]];
        }
        return frequency;
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

        //Displaying sum of digits
        System.out.println("Sum of the digits: "+sumOfDigits(num));

        //Displaying sum of square of digits
        System.out.println("Sum of the squares of digits: "+sumOfSquaresOfDigits(num));

        //Displaying results for if a number is harshad number or not
        System.out.println("Is Harshad number?: "+isHarshadNumber(num));

        //Displaying frequency of each digit
        System.out.println("Frequency of each digit: ");
        int [][]frequency = frequencyOfDigits(num);
        for(int[] freq: frequency){
            System.out.println("Frequency of "+freq[0]+": "+freq[1]);
        }
    }
}
