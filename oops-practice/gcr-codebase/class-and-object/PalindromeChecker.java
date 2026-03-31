public class PalindromeChecker {

    String text;

    public PalindromeChecker(String text) {
        this.text = text;
    }

    
    public boolean isPalindrome(){
        String str = text.replace(" ","").toLowerCase();
        for(int i=0; i<str.length()/2 ; i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        PalindromeChecker string1 = new PalindromeChecker("A man a plan a canal Panama");
        PalindromeChecker string2 = new PalindromeChecker("Hello");

        boolean isPalindrome1 = string1.isPalindrome();
        boolean isPalindrome2 = string2.isPalindrome();

        System.out.println(string1.text+" is "+(isPalindrome1?"":"not ")+"palindrome");
        System.out.println(string2.text+" is "+(isPalindrome2?"":"not ")+"palindrome");
    
    }
}