import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestSubstring {
    public static boolean isUnique(String s){
        char []ch=new char[s.length()];
        for(int i=0;i<s.length();i++)
            ch[i]=s.charAt(i);
        Arrays.sort(ch);
        for(int i=1;i<s.length();i++){
            if(ch[i-1]==ch[i])
            return false;
        }
        return true;
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
        return 0;
        List<Integer> len=new  ArrayList<>();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(isUnique(s.substring(i,j)))
                len.add(j-i);
                else
                break;
            }
        }
        Collections.sort(len);
        return len.get(len.size()-1);
    }
    public static void main(String[] args) {
        LongestSubstring ls=new LongestSubstring();
        String s="abcabcbb";
        int result=ls.lengthOfLongestSubstring(s);  
        System.out.println("Length of longest substring without repeating characters: "+result);
    }
}
