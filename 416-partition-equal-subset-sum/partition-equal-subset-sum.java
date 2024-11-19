class Solution {
    
    public boolean solve(int[] nums, int ind, int target,Boolean[][] dp){
        if(target==0)return true;
        if(ind<0 || target<0)return false;
        if(dp[ind][target]!=null)return dp[ind][target];
        boolean take = solve(nums, ind-1,target-nums[ind],dp);
        boolean notTake = solve(nums, ind-1,target,dp);
        
        return dp[ind][target]=take || notTake;
    }
    
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0)return false;
        Boolean[][] dp = new Boolean[n+1][(sum/2)+1];
        return solve(nums, n-1, sum/2,dp);
        
    }
}