class Solution {
    private boolean solve(int i, int[][] graph, HashMap<Integer, Boolean> map){
        if(map.containsKey(i)){
            return map.get(i);
        }
        map.put(i, false);
        for(int neighbour: graph[i]){
            if(solve(neighbour,graph,map)==false){
                return map.get(i);
            }
        }

        map.put(i, true);
        return map.get(i);

    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();

        int n=graph.length;

        for(int i=0;i<n;i++){
            if(solve(i,graph, map)){
                ans.add(i);
            }
        }


        return ans;
    }
}