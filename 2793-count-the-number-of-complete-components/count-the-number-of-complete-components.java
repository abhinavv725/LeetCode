class Solution {
    private boolean isComplete(int src, List<List<Integer>> adj, 
        boolean[] vis){
        int nodes=1;
        int edges=0;

        Queue<Integer> q= new LinkedList<>();
        q.add(src);vis[src]=true;
        while(!q.isEmpty()){
            int n = q.poll();
            for(int nei: adj.get(n)){
                edges++;
                if(!vis[nei]){
                    q.add(nei);
                    nodes++;
                    vis[nei]=true;
                }
            }
        }
        return (edges/2) == (nodes *(nodes-1))/2;

    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int res=0;
        boolean[] vis = new boolean[n];
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        for(int i=0;i<n;i++){
            if(vis[i]==false){
                if(isComplete(i, adj, vis)){
                    res++;
                }
            }
        }


        return res;
    }
}