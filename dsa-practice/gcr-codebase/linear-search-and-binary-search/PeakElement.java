public class PeakElement {

    public static int findPeakElement(int[] nums){
        if(nums.length==0 || nums==null){
            return -1;
        }
        if(nums.length == 1){
            return nums[1];
        }
        int start = 0;
        int end = nums.length - 1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(mid==0){
                if(nums[mid]>nums[mid+1]){
                    return nums[mid];
                }
                start=mid+1;
            }
            else if(mid==nums.length-1){
                if(nums[mid]>nums[mid-1]){
                    return nums[mid];
                }
                end = mid-1;
            }
            else if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return nums[mid];
            }
            else if(nums[mid]<nums[mid-1]){
                end = mid-1;
            }
            else if(nums[mid] < nums[mid+1]){
                start = mid+1;
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        int []nums = {1,2,1,3,5,6,4};
        System.out.println("Peak element: "+findPeakElement(nums));
    }
}
