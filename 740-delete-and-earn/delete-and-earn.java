class Solution {
    
    public int deleteAndEarn(int[] nums) {
        int n = Arrays.stream(nums).max().orElse(0);

        int[] dp = new int[n+1];

        for(int i: nums){
            dp[i]+=i;
        }
        
        for(int i=2;i<=n;i++){
            dp[i]= Math.max(dp[i-1], dp[i]+dp[i-2]);
        }
        return dp[n];

    }
}