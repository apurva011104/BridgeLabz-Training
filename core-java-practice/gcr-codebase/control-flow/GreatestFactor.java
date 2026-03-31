import java.util.Scanner;

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=scan.nextInt();
        int greatestFactor=1;
        for(int i=num/2 ; i>=1 ; i--){
            if(num%i==0){
                greatestFactor=i;
                break;
            }
        }
        System.out.println("Greatest factor of "+num+" is: "+greatestFactor);
        scan.close();
    }
}
