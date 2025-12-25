import java.util.ArrayList;
import java.util.Scanner;

public class NumberChecker4 {

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

    //Product of digits of the number
    public static int productOfDigits(int num){
        int []digitsArray= digitsArray(num);
        int product=1;
        for(int i:digitsArray){
            product*=i;
        }
        return product;
    }


    //Check if number is prime or not
    public static boolean isPrimeNumber(int num){
        if(num==1 || (num%2==0 && num!=2)){
            return false;
        }
        for(int i=3;i<=num/2;i+=2){
            if(num%i==0){
                return false;
            }
        }
        return true;

    }
    
    //Check if number is neon number or not
    public static boolean isNeonNumber(int num){
        int sumOfDigitsOfSquare=sumOfDigits(num*num);
        return num==sumOfDigitsOfSquare;
    }

    //Check if a number is spy number or not
    public static boolean isSpyNumber(int num){
        int sumOfDigits=sumOfDigits(num);
        int productOfDigits = productOfDigits(num);
        return productOfDigits==sumOfDigits;
    }

    //Check if a number is spy number or not
    public static boolean isAutomorphicNumber(int num){
        int[] digitsArrayOfSquare = digitsArray(num*num);
        int[] digitsArray = digitsArray(num);
        for(int idx1=digitsArray.length-1, idx2=digitsArrayOfSquare.length-1; idx1>=0 && idx2>=0 ; idx1-- , idx2--){
            if(digitsArray[idx1]!=digitsArrayOfSquare[idx2]){
                return false;
            }
        }
        return true;
    }

    //Check if a number is buzz number
    public static boolean isBuzzNumber(int num){
        return num%7==0 || num%10==7;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter an integer n (0<=n): ");
        int num=scan.nextInt();
        while(num<0){
            System.out.print("Please enter a number greater than or equal to 0: ");
            num=scan.nextInt();
        }

        //Displaying results for prime number check
        System.out.println("Is prime number?: "+isPrimeNumber(num));

        //Displaying results for neon number check
        System.out.println("Is neon number?: "+isNeonNumber(num));

        //Displaying results for spy number check
        System.out.println("Is spy number?: "+isSpyNumber(num));

        //Displaying results for automorphic number check
        System.out.println("Is automorphic number?: "+isAutomorphicNumber(num));

        //Displaying results for buzz number check
        System.out.println("Is buzz number?: "+isBuzzNumber(num));
    }
    
}
