class Solution {
    private int findNode(int u, int[] parent){
        if(parent[u]==u){
            return u;
        }
        return parent[u]=findNode(parent[u], parent);
    }

    boolean ifUnion(int u, int v,int[] parent,int[] rank){
        int rootU = findNode(u,parent);
        int rootV = findNode(v, parent);

        //both share the same root node, hence they are in a cycle
        if(rootU==rootV)
            return false;
        if(rank[rootU]>rank[rootV]){
            parent[rootV]=rootU;
        }else if(rank[rootU]<rank[rootV]){
            parent[rootU]=rootV;
        }else{
            parent[rootV] = rootU;
            rank[rootU]++;
        }
        
        return true;

    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for(int i=0;i<n;i++){
            rank[i]=0;
            parent[i]=i;
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(!ifUnion(u,v,parent,rank)){
                return edge;
            }
            
        }
        return new int[0];
    }
}