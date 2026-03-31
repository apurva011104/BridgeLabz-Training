import java.util.Scanner;

public class PalindromeString {

    public static boolean isPalindrome(String text){
        for(int i=0;i<text.length()/2;i++){
            if(text.charAt(i)!=text.charAt(text.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
		System.out.print("Enter text: ");
		String text = scan.next().toLowerCase();
        System.out.println("Is palindrome?: "+isPalindrome(text));
    }
}
