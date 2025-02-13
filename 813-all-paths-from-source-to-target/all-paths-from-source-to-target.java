class Solution {
    private void dfs(int node, int[][] graph, List<Integer> temp, List<List<Integer>> ans){
        temp.add(node);
        if(node == graph.length-1){
            ans.add(new ArrayList<>(temp));
        }
        for(int nei: graph[node]){
            dfs(nei, graph, temp,ans);
        }
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0,graph, new ArrayList<>(), ans);
        return ans;
    }
}