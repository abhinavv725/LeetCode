class Solution {
    private long ans, s;
    private int dfs(int node, int parent, List<List<Integer>> adj){
        int people =1;

        for(int x: adj.get(node)){
            if(x==parent)
                continue;
            people+=dfs(x, node, adj);
        }
        if(node!=0)
            ans += (people+s-1)/s;
        return people;

    }
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> adj = new ArrayList<>();
        s=seats;
        for(int i=0;i<roads.length+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] r: roads){
            adj.get(r[0]).add(r[1]);
            adj.get(r[1]).add(r[0]);
        }

        dfs(0,-1, adj);
        return ans;
    }
}