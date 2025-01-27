class Solution {
    private boolean checkCycle(int i, List<Integer>[] adj,
                                boolean[] visited,boolean[] pathVisit){
        if(visited[i]==true)
            return false;
        
        if(pathVisit[i]==true){
            return true;
        }
        
        pathVisit[i]=true;

        for(int x: adj[i]){
            if(checkCycle(x, adj, visited, pathVisit)){
                return true;
            }
        }

        visited[i]=true;
        pathVisit[i]=false;
        return false;

    }
    private void dfs(int i, List<Integer>[] adj,boolean[] visit,Stack<Integer> st){
        visit[i]=true;
        for(int x: adj[i]){
            if(!visit[x])
                dfs(x, adj, visit, st);
        }
        st.push(i);

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];

        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] pre: prerequisites){
            int course = pre[0];
            int prereq = pre[1];

            adj[prereq].add(course);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisit = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(visited[i]==false){
                if(checkCycle(i, adj,visited, pathVisit)==true)
                    return new int[] {};
            }
        }
        Stack<Integer> st = new Stack<>();
        visited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                dfs(i,adj, visited,st);
            }
        }

        int[] result = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i]=st.pop();
        }
        return result;
    }
}