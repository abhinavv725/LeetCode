class Solution {
    
    private int dfs(int i, int prev, int[] nums,int[][] dp){
        if(i==nums.length){
            return 0;
        }
        if( dp[i][prev+1]!=-1)      return  dp[i][prev+1];
        int len = 0+dfs(i+1, prev, nums,dp);
        if(prev==-1 || nums[i]> nums[prev]){
            len = Math.max(len, 1+dfs(i+1, i, nums,dp));
        }
        return dp[i][prev+1]=len;

    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] r : dp){
            Arrays.fill(r,-1);
        }
        return dfs(0, -1, nums, dp);
        
    }
}