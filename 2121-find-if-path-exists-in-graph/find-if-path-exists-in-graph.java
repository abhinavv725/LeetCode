class Solution {
    private void dfs(int node, List<List<Integer>> adj,  boolean[] vis){
        vis[node]=true;
        for(int nei: adj.get(node)){
            if(!vis[nei]){
                dfs(nei, adj, vis);
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        dfs(source, adj, vis);
        return vis[destination];
    }
}