public class FirstAndLastPositionOfElementInSortedArray {
    
    public  static  int lastOccurence(int nums[],int target){
        int start=0, end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1)
                    return mid;
                else if(nums[mid+1]==target)
                    start=mid+1;
                else
                    return mid;
            }
            else if(nums[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }

    public static int firstOccurrence(int nums[],int target){
        int start=0, end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                if(mid==0)
                    return 0;
                else if(nums[mid-1]==target)
                    end=end-1;
                else
                    return mid;
            }
            else if(nums[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }

    public static int[] searchRange(int []nums, int target){
        int arr[]={firstOccurrence(nums,target),lastOccurence(nums,target)};
        return arr;
    }

    public static void main(String[] args) {
        int []nums={5,7,7,8,8,10};
        int target = 8;
        int []occurences = searchRange(nums, target);
        System.out.println("First occurence: "+occurences[0]);
        System.out.println("Last occurence: "+occurences[1]);
    }
}
