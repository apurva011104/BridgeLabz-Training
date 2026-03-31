import java.util.HashSet;
import java.util.Set;


public class LongestSubstring {

    public static boolean isUnique(String s){
        Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){      //If the character is already in the set, it's not unique
                return false;
            }
            set.add(s.charAt(i));        //Add the character to the set
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){      //Edge case: if the string is empty, return 0
            return 0;
        }
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(isUnique(s.substring(i,j))){      //Check if the substring has all unique characters
                    maxLen=Math.max(maxLen,j-i);        //Update maxLen if the current substring is longer
                }
                else{
                    break;
                }
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        LongestSubstring ls=new LongestSubstring();
        String s="abcabcbb";
        int result=ls.lengthOfLongestSubstring(s);  
        System.out.println("Length of longest substring without repeating characters: "+result);
    }
}
