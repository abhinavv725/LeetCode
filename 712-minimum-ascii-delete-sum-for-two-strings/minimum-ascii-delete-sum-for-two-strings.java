class Solution {
    private int getAscII(String s){
        int x=0;
        for(char c: s.toCharArray()){
            x+= (int) c;
        }
        return x;
    }
    private int getLCS(String s1, String s2){
        int m = s2.length(); int n= s1.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)== s2.charAt(j-1)){
                    dp[i][j]= ((int) s1.charAt(i-1))+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];

    }
    public int minimumDeleteSum(String s1, String s2) {
        return getAscII(s1)+getAscII(s2) - 2* getLCS(s1, s2);
        
    }
}