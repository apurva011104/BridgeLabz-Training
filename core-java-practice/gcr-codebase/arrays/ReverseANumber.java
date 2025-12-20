import java.util.Scanner;

public class ReverseANumber {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num=scan.nextInt();
        int originalNum=num;

        int numberOfDigits=0;
        while(num>0){
            num/=10;
            numberOfDigits++;
        }

        int []digits=new int[numberOfDigits];
        num=originalNum;
        for(int i=0;i<numberOfDigits;i++){
            digits[i]=num%10;
            num/=10;
        }
        int reverseNumber=0;
        for(int i=0;i<numberOfDigits;i++){
            reverseNumber=(reverseNumber*10)+digits[i];
        }

        System.out.println("Original number: "+originalNum);
        System.out.println("Reverse number: "+reverseNumber);

    }
}
