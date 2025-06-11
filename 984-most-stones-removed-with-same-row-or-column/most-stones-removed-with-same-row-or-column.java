class DSU {
    int[] parent;
    int[] rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(rank, 1);
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public int find(int n){
        if(parent[n]==n){
            return n;
        }
        return parent[n] = find(parent[n]);
    }
    public void union(int a, int b){
        if(isConnected(a, b)){
            return;
        }
        int rootA = find(a);
        int rootB = find(b);
        if(rank[rootA]>rank[rootB]){
            parent[rootB]=rootA;
            rank[rootA]+=rank[rootB];
        }else{
            parent[rootA]=rootB;
            rank[rootB]+=rank[rootA];
        }
        return;
    }
    public boolean isConnected(int a, int b){
        return find(a)==find(b);
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length, count=0;
        DSU dsu = new DSU(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int a = stones[i][0], b = stones[i][1];
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    dsu.union(i, j);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dsu.parent[i]==i){
                count++;
            }
        }

        return n-count;
    }
}