public class RotationPoint {

    public static int findRotationPoint(int []nums){ 
        int start=0, end = nums.length-1;
        if(nums[start]<=nums[end]){
            return 0;
        }
        while(start<=end){
            if(start==end){
                return start;
            }
            int mid = start + (end - start)/2;
            if(mid<end && nums[mid]>nums[mid+1]){
                return mid+1;
            }
            if(mid>start && nums[mid]<nums[mid-1]){
                return mid;
            }
            if(nums[start]<=nums[mid]){
                start=mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int []nums = {4,5,6,7,0,1,2};
        int rotationPoint = findRotationPoint(nums);
        System.out.println("Rotation Point: "+rotationPoint);
    }
}
