import java.util.Scanner;

public class DivisbleByFive {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int num=scan.nextInt();
        System.out.print("Is the number " + num  +"divisible by 5? ");
        if(num%5==0){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        scan.close();
    }
}
