class Solution {
    int[] parent ;
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

        if(rootA==rootB)
            return false;
        if(rootA>rootB){
            parent[rootB]=rootA;
            rank[rootA]+=rank[rootB];
        }else{
            parent[rootA]=rootB;
            rank[rootB]+=rank[rootA];
        }

        return true;
    }
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a,b) -> Integer.compare(a[0], b[0]));
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(parent, -1);
        int groups= n;
        for(int[] l: logs){
            if(union(l[1], l[2]))
                groups--;
            
            if(groups==1)
                return l[0];
        }
        return -1;
    }
}