class Solution {
    private boolean dfs(int node, int parent,  List<List<Integer>> adj, boolean[] vis){
        vis[node]=true;
        for(int nei: adj.get(node)){
            if(vis[nei] && nei!=parent)
                return false;
            if(vis[nei] && nei==parent)
                continue;
            if(dfs(nei, node, adj, vis)==false)
                return false;
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        if(dfs(0, -1,adj, vis)==false){
            return false;
        }
        for(int i=1;i<n;i++){
            if(vis[i]==false)
                return false;
        }
        return true;

    }
}