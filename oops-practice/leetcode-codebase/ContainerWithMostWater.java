public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int l=0, r=height.length-1;
        int maxArea=0;
        while(l<r){
            while(l<r && height[l]<=height[r]){
                int area=height[l]*(r-l);
                maxArea=Math.max(area,maxArea);
                l++;
            }
            while(l<r && height[l]>=height[r]){
                int area=height[r]*(r-l);
                maxArea=Math.max(area,maxArea);
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int []height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Maximum area: "+maxArea(height));
    }
}
