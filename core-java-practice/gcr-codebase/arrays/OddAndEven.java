import java.util.Scanner;

public class OddAndEven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number=scan.nextInt();

        if(number<1){
            System.out.println("Error! Not a natural number");
        }
        else{

            int halfOfNumber=number/2;
            int oddLength = halfOfNumber + (number%2==0?0:1);
            int evenLength= halfOfNumber;

            int odd[]=new int[oddLength];
            int even[]=new int[evenLength];

            for(int i=0;i<number;i++){
                if((i+1)%2==1){
                    odd[i/2]=i+1;
                }
                else{
                    even[i/2]=i+1;
                }
            }

            System.out.print("Odd numbers: ");
            for(int o: odd){
                System.out.print(o+" ");
            }
            System.out.println();

            System.out.print("Even numbers: ");
            for(int e: even){
                System.out.print(e+" ");
            }

        }
        
        scan.close();
    }    
}
