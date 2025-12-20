import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=scan.nextInt();
        if(num<1){
            System.out.println("No prime number check for numbers less than 1");
        }
        else if(num==1){
            System.out.println("1 is not a prime number");
        }
        else{
            boolean isPrime=true;
            for(int i=2;i<num;i++){
                if(num%i==0){
                    isPrime=false;
                    break;
                }
            }
            System.out.println(num+ " is "+ ( isPrime ? "" : "not" ) + " a Prime Number");
        }
    }
}
