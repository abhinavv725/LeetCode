class Solution {
    private int bfs(int i, List<List<Integer>> adj, int[] ans){
        HashSet<Integer> set = new HashSet<>();
        for(int nei: adj.get(i)){
            if(ans[nei-1]!=0){
                set.add(ans[nei-1]);
            }
        }
        for(int j=1;j<=4;j++){
            if(!set.contains(j)){
                return j;
            }
        }
        return -1;
    }
    public int[] gardenNoAdj(int n, int[][] paths) {
        // boolean vis = new boolean[n+1];
        int[] ans = new int[n];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] path: paths){
            adj.get(path[0]).add(path[1]);
            adj.get(path[1]).add(path[0]);
        }

        for(int i=1;i<=n;i++){
            ans[i-1] = bfs(i, adj, ans);
        }
        return ans;
    }
}