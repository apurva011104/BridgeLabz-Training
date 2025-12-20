
import java.util.Scanner;

public class LargestAndSecondLargestDigit {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);

        System.out.print("Enter a number");
        int num=scan.nextInt();

        int []digits=new int[10];
        int index=0;
        int originalNum=num;

        while(index<10 && num>0){
            digits[index]=num%10;
            num/=10;
        }

        int []largest=new int[2];

        for(int i=0;i<10;i++){
            if(digits[i]>largest[0]){
                largest[1]=largest[0];
                largest[0]=digits[i];
            }
        }

        System.out.println("Largest digit in "+originalNum+" is "+largest[0]);
        System.out.println("Second largest digit in "+originalNum+" is "+largest[1]);

    }
}
