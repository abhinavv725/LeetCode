class Solution {
    private int solve(int i,int[] arr,int k){
        if(i>=arr.length)
            return 0;
        int curr=-1, result = 0;
        for(int j=i;j<arr.length && j-i+1<=k;j++){
            curr = Math.max(curr, arr[j]);
            result = Math.max(result, (j-i+1)*curr +solve(j+1, arr, k));
        }
        return result;
    }
    private int tab(int[] arr, int k){
        int n=arr.length;
        int[] dp = new int[n+1];

        for(int start = n-1;start>=0;start--){
            int currMax=-1;
            int end = Math.min(n, start+k);

            for(int i=start;i<end;i++){
                currMax = Math.max(currMax, arr[i]);
                dp[start] = Math.max(dp[start], dp[i+1] + currMax*(i-start+1));
            }
        }
        return dp[0];
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return tab( arr, k);
    }
}