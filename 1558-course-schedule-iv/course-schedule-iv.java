class Solution {
    private void bfs(int node,List<List<Integer>> adj, boolean[] visit,boolean[][] reachable ){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visit[node]=true;
        reachable[node][node]=true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neighbour: adj.get(curr)){
                if(!reachable[node][neighbour]){
                    reachable[node][neighbour]=true;
                    q.add(neighbour);
                }
                
            }
        }

    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reachable = new boolean[numCourses][numCourses];
        boolean[] visit = new boolean[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i=0;i<numCourses;i++){
            if(visit[i]==false){
                bfs(i, adj, visit, reachable);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(reachable[query[0]][query[1]]);
        }
        return ans;

        
    }
}