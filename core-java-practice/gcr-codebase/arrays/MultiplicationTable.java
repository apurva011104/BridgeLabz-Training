import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scan.nextInt();

        int []multiples = new int[10];

        for( int i=1 ; i<=10 ; i++ ){
            multiples[i-1]=num*i;
        }

        for(int i=0 ; i<10 ; i++){
            System.out.printf("%d * %d = %d",num,(i+1),multiples[i]);
            System.out.println("");
        }

        scan.close();
    }
}
