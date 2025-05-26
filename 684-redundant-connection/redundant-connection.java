class Solution {
    int[] parent;
    int[] rank;
    private int find(int x){
        if(parent[x]==-1){
            return x;
        }
        return parent[x] = find(parent[x]);

    }
    private boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB)
            return false;
        
        if(rank[rootA]>rank[rootB]){
            parent[rootB] = rootA;
            rank[rootA] += rank[rootB];
        }else{
            parent[rootA] = rootB;
            rank[rootB] += rank[rootA];

        }

        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 1);
        for(int[] e: edges){
            int u = e[0], v=e[1];
            if(!union(u, v)){
                return e;
            }
        }
        return new int[] {0, 0};
    }
}