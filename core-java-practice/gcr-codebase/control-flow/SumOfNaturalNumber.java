import java.util.Scanner;

public class SumOfNaturalNumber {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int num=scan.nextInt();
        if(num>0){
            int sum=(num*(num+1))/2;
            System.out.println("Sum of natural numbers up to " + num + " is: " + sum);
        }
        else{
            System.out.println("The number " + num + " is not a natural number.");
        }
        scan.close();
    }
}
