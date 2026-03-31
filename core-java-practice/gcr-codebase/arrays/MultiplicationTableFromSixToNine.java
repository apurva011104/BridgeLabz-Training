import java.util.Scanner;

public class MultiplicationTableFromSixToNine {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num=scan.nextInt();

        int []multiples = new int[4];

        for(int i=6;i<=9;i++){
            multiples[i-6]=num*i;
        }

        for(int i=6;i<=9;i++){
            System.out.printf("%d * %d = %d",num,i,multiples[i-6]);
            System.err.println();
        }

        scan.close();
    }
}
