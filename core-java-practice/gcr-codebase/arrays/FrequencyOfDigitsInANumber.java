
import java.util.Scanner;

public class FrequencyOfDigitsInANumber {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter a number");
        int number = scan.nextInt();
        int []digits=new int[10];
        int originalNum=number;
        while(number>0){
            digits[number%10]++;
            number/=10;
        }

        for(int i=0;i<9;i++){
            System.out.println("Frequency of digit "+i+" in number "+originalNum+" is "+digits[i]);
        }

        scan.close();
    }
}
