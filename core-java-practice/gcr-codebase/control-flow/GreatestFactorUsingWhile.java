import java.util.Scanner;

public class GreatestFactorUsingWhile {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=scan.nextInt();
        int factor=num/2;
        while(factor>=1){
            if(num%factor==0){
                break;
            }
            factor--;
        }
        System.out.println("Greatest factor of "+num+" is: "+factor);
        scan.close();
    }
}
