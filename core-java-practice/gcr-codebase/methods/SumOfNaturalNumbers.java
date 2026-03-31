import java.util.Scanner;

public class SumOfNaturalNumbers {

    public static int sumOfNaturalNumbers(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n=scan.nextInt();
        if(n<1){
            System.out.println("Not a natural number.");
        }
        else{
            int sum=sumOfNaturalNumbers(n);
            System.out.println("Sum of "+n+" natural numbers= "+sum);
        }
        scan.close();
        
    }
}
