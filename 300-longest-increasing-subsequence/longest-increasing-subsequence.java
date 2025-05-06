class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans=0;

        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(nums[i]<nums[j]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    
                }
            }
            ans=Math.max(ans, dp[i]);
        }
        return ans;
    }
}