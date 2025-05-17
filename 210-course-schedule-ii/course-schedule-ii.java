class Solution {
    List<Integer> ans = new ArrayList<>();
    private boolean dfs(int node,List<List<Integer>> adj, boolean[] vis, boolean[]temp ){
        vis[node]=true;
        temp[node]=true;
        for(Integer nei: adj.get(node)){
            if(temp[nei]==true){
                return false;
            }
            if(!vis[nei]){
                if(dfs(nei, adj, vis, temp)==false)
                    return false;
            }
        }
        
        temp[node]=false;
        ans.add(node);
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }   
        for(int[] p:prerequisites ){
            adj.get(p[0]).add(p[1]);
        }

        int[] arr = new int[numCourses];
        boolean[] vis = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(i, adj, vis, new boolean[numCourses])==false)
                    return new int[] {};
            }
        }
        for(int i=0;i<ans.size();i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
}