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
        if(n==0)return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                    res=Math.max(res, dp[i]);
                }
            }
        }
        return res;
        
    }
}