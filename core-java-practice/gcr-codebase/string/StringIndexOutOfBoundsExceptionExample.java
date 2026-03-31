import java.util.Scanner;

public class StringIndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        int index=text.length();
        try {
            char ch=text.charAt(index);
            System.out.println("Character at index "+index+" is: "+ch);
        } 
        catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}
