import java.util.Scanner;

public class PowerOfANumberUsingWhile {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=scan.nextInt();
        System.out.print("Enter the power: "); 
        int power=scan.nextInt();
        int result=1;
        int count=1;
        while(count<=power){
            result*=num;
            count++;
        }
        System.out.println(num+" raised to the power "+power+" is: "+result);
        scan.close();
    }
}
