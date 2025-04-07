class Solution {
    int[] dp;
    private int check(int n){
        int res = Integer.MIN_VALUE;
        if(dp[n]!=-1)
            return dp[n];
        for(int i=1;i<n;i++){
            int prod = i*Math.max(n-i , check(n-i));
            res= Math.max(prod, res);
        }
        return dp[n]= res;
        
    }
    public int integerBreak(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return check(n);
    }
}