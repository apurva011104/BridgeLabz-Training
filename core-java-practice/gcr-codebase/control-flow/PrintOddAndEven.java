import java.util.Scanner;

public class PrintOddAndEven {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        if(num<=0){
            System.out.println("Not a positive integer.");
            return;
        }
        System.out.print("Even numbers: ");
        for(int i=1;i<=num;i++){
            if(i%2==0){
                System.out.print(i+" ");
            }
        }
        System.out.println();
        System.out.print("Odd numbers: ");
        for(int i=1;i<=num;i++){
            if(i%2==1){
                System.out.print(i+" ");
            }
        }
    }
}
