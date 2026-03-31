import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker1 {

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

    //Check if a number is armstrong number or not
    public static boolean isArmstrongNumber(int num){
        int sum=0;
        int []digitsArray = digitsArray(num);
        for(int i: digitsArray){
            sum += (int)Math.pow(i,3);
        }
        return sum==num;
    }

    //Finding largest and second largest digit in an array.
    public static int[] largestAndSecondLargestDigit(int num){
        int []digitsArray = digitsArray(num);

        //Finding largest
        int largest=-1;
        for(int i: digitsArray){
            largest=Math.max(largest,i);
        }

        //Finding second largest
        int secondLargest = -1;
        for(int i: digitsArray){
            if(i!=largest){
                secondLargest=Math.max(secondLargest,i);
            }
        }
        return new int[]{largest,secondLargest};
    }

    //Finding smallest and second smallest digit in an array.
    public static int[] smallestAndSecondSmallestDigit(int num){
        int []digitsArray = digitsArray(num);

        //Finding smallest
        int smallest=10;
        for(int i: digitsArray){
            smallest=Math.min(smallest,i);
        }

        //Finding second smallest
        int secondSmallest = 10;
        for(int i: digitsArray){
            if(i!=smallest){
                secondSmallest=Math.min(secondSmallest,i);
            }
        }
        return new int[]{smallest,secondSmallest};
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

        //Displaying if number is a duck number
        System.out.println("Is duck number? "+isDuckNumber(num));

        //Displaying if number is a armstrong number
        System.out.println("Is armstrong number? "+isArmstrongNumber(num));

        //Displaying largest and second largest digit in the number.
        int []largestAndSecondLargestDigit = largestAndSecondLargestDigit(num);
        System.out.println("Largest digit: "+largestAndSecondLargestDigit[0]);
        if(largestAndSecondLargestDigit[1]==-1){
            System.out.println("No second largest digit");
        }
        else{
            System.out.println("Second largest digit: "+largestAndSecondLargestDigit[1]);
        }

        //Displaying smallest and second smallest digit in the number.
        int []smallestAndSecondSmallestDigit = smallestAndSecondSmallestDigit(num);
        System.out.println("Smallest digit: "+smallestAndSecondSmallestDigit[0]);
        if(smallestAndSecondSmallestDigit[1]==10){
            System.out.println("No second smallest digit");
        }
        else{
            System.out.println("Second smallest digit: "+smallestAndSecondSmallestDigit[1]);
        }

        scan.close();
    }
}
