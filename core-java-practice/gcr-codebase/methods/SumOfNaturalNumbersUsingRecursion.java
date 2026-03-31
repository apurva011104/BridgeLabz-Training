import java.util.Scanner;

public class SumOfNaturalNumbersUsingRecursion {

    public static int sumUsingRecursion(int number, int sum){
        if(number==0){
            return sum;
        }
        return sumUsingRecursion(number-1, sum+number);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num=scan.nextInt();

        int sumUsingRecursion = sumUsingRecursion(num,0);
        int sumUsingFormula = (num*(num+1))/2;
        if(sumUsingRecursion==sumUsingFormula){
            System.out.println("Sum using recursion and sum using formula are equal and equals to "+sumUsingRecursion);
        }
        else{
            System.out.println("Sum using recursion and sum using formula are not equal");
            System.out.println("Sum using recursion: "+sumUsingRecursion);
            System.out.println("Sum using formula: "+sumUsingFormula);
        }
    }
}
