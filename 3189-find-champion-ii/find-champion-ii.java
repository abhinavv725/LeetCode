class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        for(int[] edge: edges){
            indegree[edge[1]]++;
        }

        int ans=-1;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                if(ans==-1)
                    ans=i;
                else
                    return -1;
            }
        }
        return ans;
    }
}