class Solution {
    
    private int findParent(int n, int[] parent){
        return parent[n]==n ? n : findParent(parent[n], parent);
    }
    private boolean union(int x, int y, int[] rank, int[] parent){
        int xSet = findParent(x, parent), ySet = findParent(y, parent);
        if(xSet==ySet)
            return false;
        
        if(rank[xSet]> rank[ySet])
            parent[ySet] = xSet;
        else{
            parent[xSet] = ySet;
            if(rank[xSet]==rank[ySet])
                rank[xSet]++;
        }

        return true;

    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            if(findParent(u, parent) == findParent(v, parent)){
                return e;
            }
             union(u,v, rank, parent);


        }
        return new int[] {};
    }
}