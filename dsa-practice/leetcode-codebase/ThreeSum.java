
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Leetcode question 15

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> answer=new ArrayList<>();
        for(int i=0;i<len;i++){
            if(i>0 && nums[i]==nums[i-1])       continue;
            int j=i+1, k=len-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0)   j++;
                else if(sum>0)  k--;
                else{
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    answer.add(list);
                    while(j<k && nums[j]==nums[j+1])    j++;
                    while(j<k && nums[k]==nums[k-1])    k--;
                    j++;
                    k--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> triplets = threeSum(nums);
        System.out.println("Triplets: "+triplets);
    }
}
