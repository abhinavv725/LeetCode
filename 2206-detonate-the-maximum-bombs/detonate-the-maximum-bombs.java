class Solution {
    private boolean inRange(int[] a, int[] b){
        long dx = a[0] - b[0];
        long dy = a[1] - b[1];
        long distSqr = dx * dx + dy * dy;                 // Euclidean distance squared
        long radius = (long) a[2] * a[2];                 // Square of the blast radius
        return distSqr <= radius;     
    }
    private int dfs(int node,List<List<Integer>> adj , boolean[] vis){
        vis[node]=true;
        int ans=0;
        for(int nei: adj.get(node)){
            if(!vis[nei]){
                ans+= dfs(nei, adj, vis);
            }
        }
        return 1+ans;
    }
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = bombs.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && inRange(bombs[i], bombs[j])){
                    adj.get(i).add(j);
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, dfs(i,adj,  new boolean[n]));
        }
        return ans;
    }
}