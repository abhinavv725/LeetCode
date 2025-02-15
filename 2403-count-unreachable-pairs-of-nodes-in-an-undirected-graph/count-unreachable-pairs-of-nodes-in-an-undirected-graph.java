class Solution {
    private int bfs(int i, List<List<Integer>> adj, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i]=true;
        int nodes=1;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int nei: adj.get(curr)){
                if(!vis[nei]){
                    q.add(nei);
                    vis[nei]=true;
                    nodes++;
                }
            }
        }
        return nodes;
    }
    public long countPairs(int n, int[][] edges) {
        long ans=0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        } 
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        ArrayList<Integer> componentSizes = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                componentSizes.add(bfs(i, adj, vis));
            }
        }
        long result = 0;
        long sum = 0;

        for (int size : componentSizes) {
            result += size * sum; // Pairs formed with previously counted components
            sum += size;
        }

        return result;
    }
}