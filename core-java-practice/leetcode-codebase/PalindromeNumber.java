public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0)         //Negative numbers are not palindrome
            return false;
        String str=Integer.toString(x);   //Convert the number to string
        for(int i=0;i<=str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){        //Compare characters from start and end
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber pn=new PalindromeNumber();
        int x=121;
        boolean result=pn.isPalindrome(x);
        System.out.println("Is palindrome? "+result);
    }
}
