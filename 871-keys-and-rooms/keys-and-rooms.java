class Solution {
    private void dfs(int node, List<List<Integer>> adj, boolean[]vis){
        vis[node]=true;
        for(int nei: adj.get(node)){
            if(!vis[nei]){
                dfs(nei, adj, vis);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] vis = new boolean[n];
        dfs(0, adj, vis);
        for(int i=0;i<n;i++){
            if(vis[i]==false)
                return false;
        }
        return true;
    }
}