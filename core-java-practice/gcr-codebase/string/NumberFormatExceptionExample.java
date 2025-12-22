import java.util.Scanner;

public class NumberFormatExceptionExample {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        try {
            System.out.print("Enter a string to convert into number: ");
            String text=scan.nextLine();
            int n=Integer.parseInt(text);
            System.out.println("String as number: "+n);
        } 
        catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}
