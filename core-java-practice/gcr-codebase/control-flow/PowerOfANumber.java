import java.util.Scanner;

public class PowerOfANumber {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=scan.nextInt();
        System.out.print("Enter the power: ");
        int power=scan.nextInt();
        int result=1;
        for(int i=1;i<=power;i++){
            result*=num;
        }
        System.out.println(num+" raised to the power "+power+" is: "+result);
        scan.close();
    }
}
