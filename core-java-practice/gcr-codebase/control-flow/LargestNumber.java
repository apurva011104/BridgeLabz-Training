import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter first number: ");
        int first=scan.nextInt();
        System.out.print("Enter second number: ");
        int second=scan.nextInt();
        System.out.print("Enter third number: ");
        int third=scan.nextInt();
        System.out.print("Is the first number the largest? ");
        if(first>second && first>third){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        System.out.print("Is the second number the largest? ");
        if(second>first && second>third){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        System.out.print("Is the third number the largest? ");
        if(third>first && third>second){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
