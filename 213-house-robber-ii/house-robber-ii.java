import java.util.*;
class Solution {
    
    public int solve(int[] nums,int[] dp, int i){
        
        if(i==0)return nums[i];
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        
        return dp[i]=Math.max(nums[i]+solve(nums, dp, i-2), 0+solve(nums,dp,i-1));
    }
    
    public int rob(int[] nums) {
        int i = nums.length;
        if(i==1)return nums[0];
        int[] dp1 = new int[i+1];
        Arrays.fill(dp1,-1);
        int[] dp2 = new int[i+1];
        Arrays.fill(dp2,-1);
        
        int m1= solve(Arrays.copyOfRange(nums,0,i-1), dp1, i-2);
        int m2= solve(Arrays.copyOfRange(nums,1,i), dp2, i-2);
        
        return Math.max(m1,m2);
        
    }
}