class Solution {
    private boolean solve(int i,int sum, int target, int[] nums){
        if(i<0 || sum>target)
            return false;
        
        if(sum==target)
            return true;
        
        boolean take = solve(i-1, sum+nums[i], target, nums);
        boolean notTake = solve(i-1, sum, target, nums);
        return take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums){
            sum+=i;
        }
        if(sum%2!=0){
            return false;
        }
        int n=nums.length;
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0]=true;
        for(int num: nums){
            for(int j=target;j>=num;j--){
                dp[j]=dp[j] || dp[j-num];
            }
        }
        return dp[target];
    }
}