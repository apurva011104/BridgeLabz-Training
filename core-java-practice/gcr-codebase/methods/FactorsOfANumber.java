import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FactorsOfANumber {

    public static int[] factors(int num){
        ArrayList<Integer> factors = new ArrayList<>();
        for(int i=1; i<=num/2 ; i++){
            if(num%i==0){
                factors.add(i);
            }
        }
        int []factorsArray= new int[factors.size()];
        for(int i=0 ; i< factors.size();i++){
            factorsArray[i]=factors.get(i);
        }
        return factorsArray;
    }

    public static long sumOfFactors(int []factors){
        long sum=0;
        for(int i: factors){
            sum+=i;
        }
        return sum;
    }

    public static long sumOfSquareOfFactors(int []factors){
        long squareSum=0;
        for(int i: factors){
            squareSum+=(i*i);
        }
        return squareSum;
    }

    public static long productOfFactors(int []factors){
        long product=1;
        for(int i: factors){
            product*=i;
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num=scan.nextInt();
        while(num<=0){
            System.out.print("Not a positive integer! Enter again: ");
            num = scan.nextInt();
        }

        int []factors=factors(num);
        System.out.println("Factors of number "+num+" is/are: "+Arrays.toString(factors));
        System.out.println("Sum of factors: "+sumOfFactors(factors));
        System.out.println("Sum of square of products: "+sumOfSquareOfFactors(factors));
        System.out.println("Product of factors: "+productOfFactors(factors));

    }
}
