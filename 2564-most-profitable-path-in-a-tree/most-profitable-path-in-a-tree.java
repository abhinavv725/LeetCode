class Solution {
    HashMap<Integer, Integer> map;
    int ans=0;
    int maxAns = Integer.MIN_VALUE;
    private boolean bobDfs(List<List<Integer>> adj,int node, boolean[] vis, int time){
        vis[node]=true;
        map.put(node, time);
        if(node==0){
            return true;
        }
        for(int nei: adj.get(node)){
            if(!vis[nei]){
                if(bobDfs(adj, nei, vis, time+1)){
                    return true;
                }
            }
        }
        map.remove(node);
        vis[node]=false;
        return false;

    }
    private void aliceDfs(List<List<Integer>> adj,int node, boolean[] vis, 
    int time, int[] amount){
        vis[node] =true;
        if(map.containsKey(node)){
            int bobTime = map.get(node);
            if(bobTime == time ){ // alice bob reach same time
                ans += (amount[node])/2;
            }else if(time<bobTime){
                ans+=amount[node];
            }
        }else{
            ans+=amount[node];
        }
        boolean isLeaf = true;

        for(int nei: adj.get(node)){
            if(!vis[nei]){
                isLeaf=false;
                aliceDfs(adj, nei, vis, time+1, amount);
            }
        }
        if(isLeaf){
            maxAns=Math.max(ans, maxAns);

        }
        if(map.containsKey(node)){
            int bobTime = map.get(node);
            if(bobTime == time ){ // alice bob reach same time
                ans -= (amount[node])/2;
            }else if(time<bobTime){
                ans-=amount[node];
            }
        }else{
            ans-=amount[node];
        }
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        map = new HashMap<>();
        List<List<Integer>> adj = new ArrayList<>();
        int n=amount.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[adj.size()];
        bobDfs(adj, bob, vis, 0);
        vis = new boolean[adj.size()];
        aliceDfs(adj, 0, vis,0, amount);
        return maxAns;
    }
}