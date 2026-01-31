package junit;

public class StringUtils {
    
    public static String reverse(String str){
        if(str==null){
            throw new IllegalArgumentException("String cannot be null");
        }
        StringBuilder reverse = new StringBuilder();

        for(char ch: str.toCharArray()){
            reverse.insert(0, ch);
        }

        return reverse.toString();
    }

    public static boolean isPalindrome(String str){
        if(str==null){
            throw new IllegalArgumentException("String cannot be null");
        }

        for(int i=0 ; i<str.length()/2 ; i++){
            char ch1 = Character.toLowerCase(str.charAt(i));
            char ch2 = Character.toLowerCase(str.charAt(str.length()-1-i));
            if(ch1 != ch2){
                return false;
            }
        }
        return true;
    }

    public static String toUpperCase(String str){
        if(str==null){
            throw new IllegalArgumentException("String cannot be null");
        }
        StringBuilder uppercaseString = new StringBuilder();

        for(char ch: str.toCharArray()){
            uppercaseString.append(Character.toUpperCase(ch));
        }

        return uppercaseString.toString();
    }
}
