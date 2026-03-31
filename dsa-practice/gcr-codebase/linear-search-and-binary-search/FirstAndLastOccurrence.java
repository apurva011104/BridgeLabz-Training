import java.util.Arrays;

public class FirstAndLastOccurrence {

    private static int firstOccurence(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            //System.out.println(start+" "+end+" "+mid);
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]!=target){
                    return mid;
                }
                end = mid-1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
            //System.out.println(start+" "+end+" "+mid);
        }
        return -1;
    }

    private static int lastOccurence(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]!=target){
                    return mid;
                }
                start = mid+1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }

    public static int[] searchRange(int []nums, int target){
        return new int[]{firstOccurence(nums, target), lastOccurence(nums, target)};
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,8,8,8,8,8,10};
        int target=11;
        int[] range = searchRange(nums, target);
        System.out.println("Range: "+Arrays.toString(range));


    }
}
