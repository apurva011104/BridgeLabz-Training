import java.util.Scanner;

public class MultiplesOfANumberUsingWhile {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        if(num>100){
            System.out.println(num+" is greater than 100");
        }
        else {
            int counter=100;
            while(counter>=1){
                if(num%counter==0){
                    System.out.println(num+" is a multiple of "+counter);
                }
                counter--;
            }
        }
        scan.close();
    }
}
