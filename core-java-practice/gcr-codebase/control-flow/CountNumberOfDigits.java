import java.util.Scanner;

public class CountNumberOfDigits {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=scan.nextInt();
        int originalNum=num;

        //Counting the number of digits
        int count=0;
        while(num>0){
            num/=10;
            count++;
        }
        
        System.out.println("Number of digits in "+originalNum+" is: "+count);
        scan.close();
    }
}
