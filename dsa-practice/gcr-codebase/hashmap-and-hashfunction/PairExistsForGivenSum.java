import java.util.HashMap;
import java.util.Map;

public class PairExistsForGivenSum {

    public static int[] checkIfPairExistsForTarget(int[]array, int target){

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
        int target =22;
        int[] indexes = checkIfPairExistsForTarget(array, target);
        if(indexes[0]==-1){
            System.out.println("No such pair exists");
        }
        else{
            System.out.println("Indexes: ("+indexes[0]+", "+indexes[1]+")");
        }
    }
}
