class Solution {
    private boolean inRange(int[] a, int[]b){
        long dx = a[0]-b[0];
        long dy =a[1]-b[1];
        long distSqr = dx*dx + dy*dy;
        long radius = (long)a[2]*a[2];
        return distSqr<=radius;
    }
    private int dfs(int idx, List<List<Integer>> adj, boolean[] vis){
        vis[idx] =true;
        int count=1;
        for(int nei: adj.get(idx)){
            if(!vis[nei]){
                count += dfs(nei, adj, vis);
            }
        }
        return count;
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
        int ans = 0;

        for(int i=0;i<n;i++){
            boolean[] vis = new boolean[n];
            ans = Math.max(ans, dfs(i,adj,vis));

        }
        return ans;
        
    }
}