class Solution {
    int MOD = (int) Math.pow(10, 9)+7;
    
    int[][] dir = {{4,6}, {8,6}, {7,9}, {8,4}, {3,9, 0} ,{}, {7,1, 0}, {6,2}, {1,3}, {2, 4}};
    
    public int knightDialer(int n) {
        int ans=0;
        int[][] dp = new int[n][10];
        for(int cell=0;cell<=9;cell++){
            dp[0][cell]=1;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<10;j++){
                for(int nei: dir[j]){
                    dp[i][j] = (dp[i][j]+dp[i-1][nei])%MOD;
                }
            }
        }
        for(int i=0;i<=9;i++){
            ans = (ans+dp[n-1][i])%MOD;
        }

        return ans;
    }
}