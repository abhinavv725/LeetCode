class Solution {
    private boolean bfs(int[][] graph,int[] color,int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node]=0;
        
        while(!q.isEmpty()){
            int num =q.poll();
            for(Integer it: graph[num]){
                if(color[it]==-1){
                    q.add(it);
                    color[it] = color[num]^1;
                }else if(color[it]==color[num])
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m=graph[0].length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        
        for(int i=0;i<n;i++){
            if(color[i]==-1)
                if(bfs(graph,color,i)==false)
                    return false;
        }
        
        return true;
        
        
    }
}