class Solution {
    private boolean dfs(int node, List<List<Integer>> adj,boolean[] vis, boolean[] temp){
        vis[node]=true;
        temp[node] =true;
        for(int nei: adj.get(node)){
            if(temp[nei])
                return false;
            if(!vis[nei]){
                if(dfs(nei, adj, vis, temp)==false){
                    return false;
                }
            }

        }
        temp[node] =false;
        return true;
    }
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[]p : prerequisites){
            adj.get(p[0]).add(p[1]);
        }

        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                if(dfs(i, adj, vis, new boolean[n])==false)
                    return false;
            }
        }
        return true;

        
    }
}