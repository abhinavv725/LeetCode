class Solution {
    private int bfs(List<List<Integer>> adj, int n){
        Queue<Integer> q= new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(0);
        vis[0]=true;
        int step=0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- != 0){
                int node = q.poll();
                for(int nei: adj.get(node)){
                    if(!vis[nei]){
                        vis[nei]=true;
                        q.add(nei);
                    }
                    if(nei==n-1){
                        return step+1;
                    }
                }
            }
            step++;
        }
        return -1;
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            adj.get(i).add(i+1);
        }
        int[] ans = new int[queries.length];
        int i=0;
        for(int[] query: queries){
            adj.get(query[0]).add(query[1]);
            ans[i++]=bfs(adj, n);
        }
        return ans;
    }
}