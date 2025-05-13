class Solution {
    private boolean dfs(int i, int[] nums, int target, Boolean[][] dp){
        if(target<0 || i==nums.length)
            return false;
        if(target==0)
            return dp[i][target]=true;
        
        if(dp[i][target]!=null) return dp[i][target];
        boolean pick = dfs(i+1, nums, target-nums[i], dp);
        boolean notPick = dfs(i+1, nums, target, dp);

        return dp[i][target]= pick || notPick;
    }
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2==1)    return false;

        int target =sum/2;
        Boolean[][] dp = new Boolean[nums.length][target+1];
        return dfs(0, nums, target, dp);
    }
}