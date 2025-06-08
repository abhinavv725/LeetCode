class Solution {
    int[] dp;
    private int dfs(int i, String s){
        if(i==s.length()){
            return 1;
        }
        if(s.charAt(i)=='0')  return 0;
        if(dp[i]!=-1){
            return dp[i];
        }

        int ans = dfs(i+1, s);
        if(i+1<s.length()){
            int num = Integer.parseInt(s.substring(i, i+2));
            if(num>=10 && num<=26){
                ans+=dfs(i+2, s);
            }
        }
        return dp[i]= ans;
    }
    public int numDecodings(String s) {
        dp=new int[s.length()+1];
        Arrays.fill(dp, -1);
        return dfs(0, s);
    }
}