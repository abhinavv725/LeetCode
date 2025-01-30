class Solution {
    private boolean isBipartite(int i, List<Integer>[] adj, int[] color){
        Queue<Integer> q= new LinkedList<>();
        color[i]=0;
        q.add(i);
        while(!q.isEmpty()){
            int ele = q.poll();
            for(int neighbour: adj[ele]){
                if(color[neighbour]==-1){
                    q.add(neighbour);
                    color[neighbour]=1-color[ele];
                }else if(color[neighbour] == color[ele]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] adj = new List[n+1];

        for(int i=0;i<=n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] dis: dislikes){
            adj[dis[0]].add(dis[1]);
            adj[dis[1]].add(dis[0]);
        }
        int[] color = new int[n+1];
        Arrays.fill(color,-1);

        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(!isBipartite(i, adj, color)){
                    return false;
                }
            }
        }
        return true;
    }
}