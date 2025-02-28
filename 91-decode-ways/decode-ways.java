class Solution {
    public int solve(int i, int n, String s){
        if(i==n){
            return 1;
        }
        if(s.charAt(i)=='0'){
            return 0;
        }
        int result = solve(i+1, n, s);
        if(i+1<n && (s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6'))){
            result += solve(i+2, n, s);
        }

        return result;
        
    }
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                dp[i]= 0;
            }else{
                dp[i] = dp[i+1];
                if(i+1<n && (s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6'))){
                    dp[i] += dp[i+2];
                }
            }
            

        }
        return dp[0];
        
    }
}