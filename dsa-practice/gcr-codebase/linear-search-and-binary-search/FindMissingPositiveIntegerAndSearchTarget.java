import java.util.Arrays;

public class FindMissingPositiveIntegerAndSearchTarget {

    public static int findMissingPositiveInteger(int[] nums){
        int n = nums.length+1;
        int sum = (n*(n+1))/2;
        for(int i: nums){
            sum-=i;
        }
        return sum;
    }

    public static int searchTarget(int[] nums, int target){
        int start = 0, end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,8,5,7,6};
        int target = 5;
        System.out.println("Missing positive integer: "+findMissingPositiveInteger(nums));
        Arrays.sort(nums);
        System.out.println("Index of target integer: "+searchTarget(nums, target));
    }
}
