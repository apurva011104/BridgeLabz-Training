import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] findPairs(int[]array, int target){

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(target-array[i])){
                return new int[]{map.get(target - array[i]), i};
            }
            map.put(array[i],i);
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int []array = {2,7,11,15};
        int target = 9;
        int[] indexes = findPairs(array, target);
        System.out.println("Indexes: ("+indexes[0]+", "+indexes[1]+")");
    }
}
