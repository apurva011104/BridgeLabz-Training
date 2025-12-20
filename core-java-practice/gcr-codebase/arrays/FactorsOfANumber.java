import java.util.ArrayList;
import java.util.Scanner;

public class FactorsOfANumber {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num=scan.nextInt();

        if(num<=0){
            System.out.println("Not a natural number!");
        }
        else{
            ArrayList<Integer> factors = new ArrayList<>();
            for(int i=1;i<=num;i++){
                if(num%i==0){
                    factors.add(i);
                }
            }

            System.out.print("Factors of number "+num+": ");
            for(int factor: factors){
                System.out.print(factor+" ");
            }
        }

        scan.close();
    }
}
