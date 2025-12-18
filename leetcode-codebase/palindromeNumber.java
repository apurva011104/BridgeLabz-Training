public class palindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0) 
            return false;
        String str=Integer.toString(x);
        for(int i=0;i<=str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i))
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        palindromeNumber pn=new palindromeNumber();
        int x=121;
        boolean result=pn.isPalindrome(x);
        System.out.println("Is palindrome? "+result);
    }
}
