public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        if(target>nums[nums.length-1])
        return nums.length;
        if(target<=nums[0])
        return 0;
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid==0){
                if(target<=nums[mid])
                    return mid;
                else
                    return mid+1;
            }
            else{
                if(target==nums[mid] || (target>nums[mid-1] && target<nums[mid]))
                    return mid;
                else if(target>nums[mid-1] && target>nums[mid])
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []nums = {1,3,5,6};
        int target = 5;
        System.out.println("Insert position: "+searchInsert(nums, target));
    }
}
