class Solution {
    private void check(int node, List<List<Integer>> adj, Set<Integer> set,boolean[] vis){
        vis[node]=true;
        for(int nei: adj.get(node)){
            if(!set.contains(nei) && !vis[nei]){
                check(nei, adj, set, vis);
            }
        }
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        Set<Integer> set = new HashSet<>();
        for(int i: restricted){
            set.add(i);
        }
        boolean[] vis = new boolean[n];
        check(0,adj, set, vis);
        int ans=0;
        for(boolean i: vis){
            if(i)
                ans++;
        }
        return ans;
    }
}