class Solution {
    int[] parent;
    int[] rank;
    private int find(int x){
        if(parent[x]==-1){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    private boolean union(int a, int b){
        int rankA = find(a);
        int rankB = find(b);
        if(rankA==rankB)
            return false;
        
        if(rankA> rankB){
            parent[rankB] =rankA;
            rank[rankA]+=rank[rankB];
        }else{
            parent[rankA] =rankB;
            rank[rankB]+=rank[rankA];
        }
        
        return true;
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];
        rank=new int[n];
        Arrays.fill(parent, -1);

        for(int i=1;i<n;i++){
            if(Math.abs(nums[i-1]-nums[i])<=maxDiff){
                union(i-1, i);
            }
        }
        boolean[] ans = new boolean[queries.length];
        int i=0;
        for(int[]q: queries){
            ans[i++] = find(q[0]) == find(q[1]);
        }
        return ans;
    }
}