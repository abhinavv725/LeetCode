class Solution {
    private boolean checkBipartite(int i, int[][] graph,int[] color ){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i]=0;
        while(!q.isEmpty()){
            int ele = q.poll();
            for(int neighbor: graph[ele]){
                if(color[neighbor]==-1){
                    q.add(neighbor);
                    color[neighbor] = 1-color[ele];
                }else if(color[neighbor]==color[ele]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
       int n = graph.length;
       int[] color = new int[n];
       Arrays.fill(color,-1);

       for(int i=0;i<n;i++){
        if(color[i]==-1){
            if(checkBipartite(i, graph, color)==false){
                return false;
            }
        }
       }
       return true;
    }
}