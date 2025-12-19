import java.util.Scanner;

public class PrintOddAndEven {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        if(num<=0){
            System.out.println("Not a positive integer.");
            return;
        }
        for(int i=1;i<=num;i++){
            System.out.println( i+" is "+( i%2==0 ? "Even" : "Odd" ) );

        }
    }
}
