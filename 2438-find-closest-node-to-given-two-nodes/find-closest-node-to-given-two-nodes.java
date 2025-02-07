class Solution {
    private void dfs(int node, int distance, int[] edges, int[] dist, boolean[] visit){
        if(node==-1 || visit[node])
            return ;
        dist[node]=distance;
        visit[node]=true;

        if(edges[node]!=-1)
            dfs(edges[node], distance+1, edges, dist, visit);
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n= edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        boolean[] visit = new boolean[n];

        dfs(node1, 0, edges, dist1, visit);
        visit=new boolean[n];
        dfs(node2, 0, edges, dist2, visit);
        int ans=edges.length+1;
        int result=-1;
        for(int i=0;i<n;i++){
            if(dist1[i]!=-1 && dist2[i]!=-1){
                if(Math.max(dist1[i], dist2[i])<ans){
                    ans = Math.max(dist1[i], dist2[i]);
                    result=i;
                }
            }
            
        }

        return result;
    }
}