class Solution {
    int[] parent;
    int[] rank;
    private void union(int x, int y){
        int rootA = find(x);
        int rootB = find(y);

        if(rootA==rootB)
            return;
        else if(rootA>rootB){
            parent[rootB] = rootA;
            rank[rootA]+=rank[rootB];
        }else{
            parent[rootA] = rootB;
            rank[rootB]+=rank[rootA];
        }
    }
    private int find(int x){
        if(parent[x]==-1)
            return x;
        return parent[x] = find(parent[x]);
    }
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a,b)-> Integer.compare(a[0], b[0]));
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(parent, -1);

        for(int[] l: logs){
            union(l[1], l[2]);
            int p = find(0);
            boolean allFriend=true;
            for(int i=1;i<parent.length;i++){
                if(find(i)!=p){
                    allFriend=false;
                    break;
                }
            }
            if(allFriend){
                return l[0];
            }
        }
        return -1;

    }
}