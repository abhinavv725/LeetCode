class Solution {
    private void dfs(int src, List<List<Integer>> adj,
    List<List<Integer>> ans , int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        boolean[] vis = new boolean[n];
        vis[src]=true;
        while(!q.isEmpty()){
            int t = q.poll();
            for(int nei: adj.get(t)){
                if(!vis[nei]){
                    ans.get(nei).add(src);
                    q.add(nei);
                    vis[nei]=true;
                }
                
            }
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            dfs(i, adj, ans,n);
        }

        return ans;
    }
}