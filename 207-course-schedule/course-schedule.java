class Solution {
    public boolean canFinish(int V, int[][] p) {
        Queue<Integer> q= new LinkedList<>();
        int[] indegree= new int[V];
        
        for(int i=0;i<p.length;i++){
            indegree[p[i][1]]++;
        }
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0)q.offer(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i=0;i<p.length;i++){
                if(node==p[i][0]){
                    indegree[p[i][1]]--;
                    if(indegree[p[i][1]]==0)q.offer(p[i][1]);
                }
            }
        }
        for(int i=0;i<V;i++){
            if(indegree[i]!=0)return false;
        }
        return true;
    }
}