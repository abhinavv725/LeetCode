class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int m = triangle.get(n-1).size();

        int[] dp = new int[m];
        for(int i=0;i<m;i++){
            dp[i]=triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j]= triangle.get(i).get(j)+Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}