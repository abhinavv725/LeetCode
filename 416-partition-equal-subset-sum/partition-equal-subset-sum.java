class Solution {
    private boolean subset(int i, int[] nums, int target){
        if(target==0)
            return true;
        if(i>=nums.length)
            return false;
        
        return subset(i+1, nums, target-nums[i]) || subset(i+1, nums, target);

    }
    private boolean tab(int[] nums, int target){
        int n=nums.length;
        boolean[][] dp = new boolean[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                dp[i][j] = dp[i-1][j];
                if(j-nums[i]>=0){
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i]];
                }
            }
        }

        return dp[n-1][target];
    }
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int i: nums){
            sum+=i;
        }
        if(sum%2!=0)
            return false;
        return tab(nums, sum/2);
    }
}