class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] degree = new int[n+2];
        for(int[] edge: edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        for(int i=1;i<=n+1;i++){
            if(degree[i]==n){
                return i;
            }
        }
        return -1;
    }
}