import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FactorsOfANumber2 {

    //Storing factors in an array
    public static int[] factorsArray(int num){
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

    //Greatest factor
    public static int greatestFactor(int num){
        int[] factors = factorsArray(num);
        int greatestFactor = 1;
        for(int f: factors){
            Math.max(greatestFactor, f);
        }
        return greatestFactor;
    }

    //sum of factors
    public static long sumOfFactors(int num){
        int []factors = factorsArray(num);
        long sum=0;
        for(int i: factors){
            sum+=i;
        }
        return sum;
    }

    //Product of factors
    public static long productOfFactors(int num){
        int []factors = factorsArray(num);
        long product=1;
        for(int i: factors){
            product*=i;
        }
        return product;
    }

    //Product of cube of factors
    public static long productOfCubeOfFactors(int num){
        int []factors = factorsArray(num);
        long product=1;
        for(int i: factors){
            product*=(int)Math.pow(i, 3);
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

        int[]factors = factorsArray(num);
        System.out.println("Factors: "+Arrays.toString(factors));
        System.out.println("Greatest factor: "+greatestFactor(num));
        System.out.println("Sum of factors: "+sumOfFactors(num));
        System.out.println("Product of factors: "+productOfFactors(num));
        System.out.println("Product of cube of factors: "+productOfCubeOfFactors(num));
        scan.close();
    }
}
