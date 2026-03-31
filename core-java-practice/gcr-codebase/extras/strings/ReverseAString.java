import java.util.Scanner;

public class ReverseAString {

    public static String reverse(String text){
        StringBuilder reverse = new StringBuilder();
        for(int i=text.length()-1 ; i>=0; i--){
            reverse.append(text.charAt(i));
        }
        return reverse.toString();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
		System.out.print("Enter text: ");
		String text = scan.next();
        System.out.print("Reversed string: "+reverse(text));
        scan.close();

    }
}
