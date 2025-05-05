class Solution {
    int[] parent;
    int[] rank;
    private int find(int x){
        if(parent[x]==-1)
            return x;
        return parent[x]= find(parent[x]);
    }
    private void union(int x, int y){
        int rootA = find(x);
        int rootB = find(y);

        if(rootA==rootB)
            return;
        else if(rank[rootA]>rank[rootB]){
            parent[rootB] = rootA;
            rank[rootA]+=rank[rootB];
        }else{
            parent[rootA] = rootB;
            rank[rootB]+=rank[rootA];
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        parent=new int[n];
        rank = new int[n];
        Arrays.fill(parent, -1);

        for(int i=1;i<n;i++){
            if(Math.abs(nums[i-1]-nums[i])<=maxDiff){
                union(i-1, i);
            }
        }
        int i=0;
        for(int[] q: queries){
            ans[i++] = find(q[0]) == find(q[1]);
        }
        return ans;

        
        
    }
}