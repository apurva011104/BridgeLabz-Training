public class ClimbingStairs {
    
    public static int climbStairs(int n) {
        int []dp=new int[n+1];
        for(int i=0;i<=n;i++){
            if(i<=2){
                dp[i]=i;
            }
            else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println("Number of ways to climb "+n+" stairs: "+climbStairs(n));
    }
}
