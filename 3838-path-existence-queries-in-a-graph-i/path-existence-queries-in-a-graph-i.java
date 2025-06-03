class DSU {
    int[] parent;
    int[] rank;
    DSU(int n){
        rank = new int[n];
        parent= new int[n];
        Arrays.fill(rank, 1);
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }

    public int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public boolean union(int i, int j){
        if(isConnected(i, j)){
            return false;
        }
        int rootA = find(i), rootB = find(j);
        if(rank[rootA]>rank[rootB]){
            parent[rootB]=rootA;
            rank[rootA]+=rank[rootB];
        }else{
            parent[rootA]=rootB;
            rank[rootB]+=rank[rootA];
        }
        return true;
    }
    public boolean isConnected(int i, int j){
        return find(i)==find(j);
    }
}

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DSU dsu = new DSU(n);
        for(int i=1;i<n;i++){
            if(Math.abs(nums[i-1]-nums[i])<=maxDiff){
                dsu.union(i-1, i);
            }
        }
        boolean[] ans = new boolean[queries.length];
        int i=0;
        for(int[]q: queries){
            ans[i++] = dsu.isConnected(q[0], q[1]);
        }
        return ans;
    }
}