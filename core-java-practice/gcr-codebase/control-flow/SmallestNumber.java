import java.util.Scanner;

public class SmallestNumber {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter first number: ");
        int first=scan.nextInt();
        System.out.print("Enter second number: ");  
        int second=scan.nextInt();
        System.out.print("Enter third number: ");
        int third=scan.nextInt();
        System.out.print("Is the first number the smallest? ");
        if(first<second && first<third){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        scan.close();
    }    
}
