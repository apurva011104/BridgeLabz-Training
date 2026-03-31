import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public static int longestConsecutiveSequence(int[] array) {

        int maximumLength=0;

        Map<Integer,Boolean> index=new HashMap<>();

        for(int i: array){
            index.putIfAbsent(i,true);
            if(index.containsKey(i+1)){
                index.replace(i+1,false);
            }
            if(index.containsKey(i-1)){
                index.replace(i,false);
            }
        }

        for(Map.Entry<Integer,Boolean> entry: index.entrySet()){
            int count=0;
            int i=entry.getKey();
            if(entry.getValue()){
                while(index.containsKey(i)){
                    count++;
                    i++;
                }
            }
            maximumLength=Math.max(count,maximumLength);
        }
        return maximumLength;
    }

    public static void main(String[] args) {
        int[] array = {100, 4, 200, 1, 3, 2};
        int longestSequence = longestConsecutiveSequence(array);

        System.out.println("Longest consecutive Sequence: "+longestSequence);
    }
}
