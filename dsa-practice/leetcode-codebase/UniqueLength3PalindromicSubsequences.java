import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class UniqueLength3PalindromicSubsequences {

    public static int countPalindromicSubsequence(String s) {
        Map<Character,List<Integer>> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, new ArrayList<>());
            }
            map.get(ch).add(i);
        }

        int count=0;

        for(Map.Entry<Character,List<Integer>> entry: map.entrySet()){

            if(entry.getValue().size()==1){
                continue;
            }

            List<Integer> li=entry.getValue();
            int st=li.get(0)+1;
            int end=li.get(li.size()-1)-1;
            Set<Character> unique=new HashSet<>();

            while(st<=end){
                if(!unique.contains(s.charAt(st))){
                    unique.add(s.charAt(st));
                }
                st++;
            }

            count+=unique.size();
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "aabca";
        int count = countPalindromicSubsequence(s);

        System.out.println("Number of unique length-3 palindromic subsequences: " + count);
    }
}
