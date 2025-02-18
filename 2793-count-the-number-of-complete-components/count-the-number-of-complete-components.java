class Solution {
    private boolean isConnected(int j, List<List<Integer>> adj, boolean[] vis, int n){
        int nodes=1;
        int[] degree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(j);
        vis[j]=true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei: adj.get(node)){
                degree[node]++;
                if(!vis[nei]){
                    q.add(nei);
                    vis[nei]=true;
                    nodes++;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(degree[i]==0)
                continue;
            if(degree[i]!=0 && degree[i]!=nodes-1){
                return false;
            }
        }
        return true;
    }


    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        boolean[] vis = new boolean[n];
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(isConnected(i, adj, vis,n))
                    ans++;
            }
        }
        return ans;
    }
}