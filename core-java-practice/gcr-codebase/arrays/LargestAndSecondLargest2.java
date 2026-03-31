
import java.util.Scanner;

public class LargestAndSecondLargest2 {

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);

        System.out.print("Enter a number");
        int num=scan.nextInt();

        int []digits=new int[10];
        int index=0;
        int originalNum=num;

        while(num>0){
            if(index==digits.length){
                int newDigits[]=new int[digits.length+10];
                for(int i=0;i<digits.length;i++){
                    newDigits[i]=digits[i];
                }
                digits=newDigits;
            }
            digits[index]=num%10;
            index++;
            num/=10;
        }

        int []largest=new int[2];

        for(int i=0;i<digits.length;i++){
            if(digits[i]>largest[0]){
                largest[1]=largest[0];
                largest[0]=digits[i];
            }
        }

        System.out.println("Largest digit in "+originalNum+" is "+largest[0]);
        System.out.println("Second largest digit in "+originalNum+" is "+largest[1]);
    }
    
}
