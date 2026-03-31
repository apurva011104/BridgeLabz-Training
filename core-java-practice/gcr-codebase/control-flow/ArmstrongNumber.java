import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num=scan.nextInt();
        int originalNum=num;

        //Calculating the sum of cubes of each digit
        int sum=0;
        while(num>0){
            int remainder = num % 10;
            sum+=Math.pow( remainder, 3 );
            num/=10;
        }
        //Checking if the sum is equal to the original number
        if(sum==originalNum){
            System.out.println(originalNum+" is an Armstrong number.");
        } else {
            System.out.println(originalNum+" is not an Armstrong number.");
        }

        scan.close();
    }
}
