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
        if(rootA==rootB)    return false;
        
        if(rootA>rootB){
            parent[rootB] = rootA;
            rank[rootA]+=rank[rootB];
        }else{
            parent[rootA] = rootB;
            rank[rootB]+=rank[rootA];
        }

        return true;
    }
    public int earliestAcq(int[][] logs, int n) {
        parent=new int[n];
        rank=new int[n];
        Arrays.fill(parent, -1);
        Arrays.sort(logs, (a, b)-> Integer.compare(a[0], b[0]));
        int group =n;
        for(int[] log: logs){
            if(union(log[1], log[2])){
                group--;
            }
            if(group==1){
                return log[0];
            }
        }
        return -1;
    }
}