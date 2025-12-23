import java.util.Scanner;

public class PalindromeString {

    public static boolean isPalindrome(String text){
        int left=0, right=text.length()-1;
        while(left<right){
            if(text.charAt(right)!=text.charAt(left)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scan.next();
        boolean isPalindrome = isPalindrome(text);
        System.out.println("Is \""+text+"\" palindrome?: "+isPalindrome);
    }
}
