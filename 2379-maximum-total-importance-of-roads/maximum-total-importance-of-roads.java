class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];
        for(int[] road: roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }
        Arrays.sort(degree);
        long ans=0;
        for(int i=n-1;i>=0;i--){
            ans+=(i+1)*degree[i];
        }
        return ans;
    }
}