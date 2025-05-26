class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    private void dfs(int node, int[][] graph, List<Integer> temp){
        temp.add(node);
        if(node==graph.length-1){
            ans.add(new ArrayList<>(temp));
        }
        for(int nei: graph[node]){
            // if(!temp.contains(nei)){
                dfs(nei, graph, temp);
            // }
        }
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        dfs(0, graph, new ArrayList<>());
        return ans;
    }
}