class Solution {
    private int ans = Integer.MAX_VALUE;
    private class Pair {
        int i; int j; int d;
        Pair(int i, int j , int d){
            this.i=i;this.j=j;this.d=d;
        }
    }
    private void bfs(int node, List<List<Pair>> adj,boolean[] vis){
        vis[node]=true;
        for(Pair p: adj.get(node)){
            ans = Math.min(ans, p.d);
            if(vis[p.j]!=true){
                bfs(p.j, adj, vis);
            }
            if(vis[p.i]!=true){
                bfs(p.i, adj, vis);
            }
            
        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        boolean[] vis = new boolean[n+1];
        for(int i=0;i<roads.length;i++){
            Pair p = new Pair(roads[i][0], roads[i][1],roads[i][2]);
            adj.get(roads[i][0]).add(p);
            adj.get(roads[i][1]).add(p);
        }
        bfs(1, adj,vis);
        return ans;

    }
}