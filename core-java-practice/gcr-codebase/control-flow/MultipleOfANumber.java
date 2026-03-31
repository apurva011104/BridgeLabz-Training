import java.util.Scanner;

public class MultipleOfANumber {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=scan.nextInt();
        if(num>100){
            System.out.println(num+" is greater than 100");
        }
        else {
            for(int i=100 ; i>=1;i--){
                if(num%i==0){
                    System.out.println(num+" is a multiple of "+i);
                }
            }
        }
        scan.close();
    }
}
