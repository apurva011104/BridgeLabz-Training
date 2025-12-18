import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public int[] twoSum(int[]arr, int target){
        int []ans=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
                return new int[]{i,map.get(target-arr[i])};
            }
            else
                map.put(arr[i],i);
        }
        return ans;
    }
    public static void main(String[] args){
        twoSum twoSum=new twoSum();
        int arr[]={2,7,11,15,4,8,5};
        int target=9;
        int result[]=twoSum.twoSum(arr,target);
        System.out.println("Indices: "+result[0]+", "+result[1]);
    }
}
