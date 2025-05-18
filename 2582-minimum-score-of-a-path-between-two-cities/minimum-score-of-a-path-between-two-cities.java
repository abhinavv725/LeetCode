class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road: roads){
            adj.get(road[0]).add(new int[] {road[1], road[2]});
            adj.get(road[1]).add(new int[] {road[0], road[2]});
        }
        int min = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1, 0});
        boolean[] vis = new boolean[n+1];
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0], weight = curr[1];
            for(int[] nei: adj.get(node)){
                int next = nei[0], edge = nei[1];
                min = Math.min(min, edge);

                if (!vis[next]) {
                    vis[next]=true;
                    q.add(new int[] {next, edge});
                }
            
            }
            
        }
        return min;
    }
}