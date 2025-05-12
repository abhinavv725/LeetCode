class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean[] dp = new boolean[n];
        dp[0]=true;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=Math.min(n-1, i+nums[i]);j++){
                dp[j]=dp[i];
            }
        }
        return dp[n-1];
    }
}