import  java.util.Scanner;

public class TrimLeadingAndTrailingSpaces {

    public static String createSubstring(String text, int start, int end) {
		String substring="";
		for(int i=start ; i<end; i++) {
			substring+=text.charAt(i);
		}
		return substring;
	}

    public static String removeLeadingAndTrailingSpaces(String text){
        int len=text.length();
        int left=0;
        while(left<len && text.charAt(left)==' '){
            left++;
        }
        int right=len-1;
        while(right>=left && text.charAt(right)==' '){
            right--;
        }
        return createSubstring(text, left, right+1);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner (System.in);
        System.out.print("Enter a string: ");
        String text=scan.nextLine();
        String trimString=removeLeadingAndTrailingSpaces(text);
        String trimStringUsingBuiltIn=text.trim();
        System.out.println("String after removing leading and trailing spaces: "+trimString);
        System.out.println("String after rusing built-in trim method: "+trimStringUsingBuiltIn);
        System.out.println("Are both equal? "+trimString.equals(trimStringUsingBuiltIn));
    }
}
