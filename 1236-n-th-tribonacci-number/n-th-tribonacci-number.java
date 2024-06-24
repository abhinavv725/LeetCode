class Solution {
    public int tribonacci(int n) {
        int x=0,y=1,z=1;
        int[] dp = {0,1,1};
        if(n<=2){
            return dp[n];
        }
        for(int i=3;i<=n;i++){
            int temp=dp[0]+dp[1]+dp[2];
            dp[0]=dp[1];
            dp[1]=dp[2];
            dp[2]=temp;
        }
        
        return dp[2];
    }
}