class Solution {
    public int solve(int i, int[] nums,int[] dp){
        if(i==0)return nums[i];
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        
        return dp[i]=Math.max(nums[i]+solve(i-2,nums,dp),0+solve(i-1,nums,dp));
        
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(nums.length-1, nums, dp);
        
    }
}