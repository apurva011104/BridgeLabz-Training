import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String []strs){
        Arrays.sort(strs);
        int index=0;
        int length=strs.length;
        while( index < Math.min( strs[0].length(),strs[length-1].length() ) ){
            if(strs[0].charAt(index) != strs[length-1].charAt(index)){
                break;
            }
            index++;
        }
        return  strs[0].substring(0,index);
    }
    public static void main(String[] args) {
        LongestCommonPrefix lcp=new LongestCommonPrefix();
        String []strs = {"flower","flow","flight"};
        String longestCommonPrefix= lcp.longestCommonPrefix(strs);
        System.out.println("Strings array: "+Arrays.toString(strs));
        System.out.println("Longest Common Prefix: "+longestCommonPrefix);
    }
    
}
