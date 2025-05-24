class Solution {
    int[] parent;
    int[] rank;
    boolean[][] vis;
    private int find(int x){
        if(parent[x]==-1){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    private boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA==rootB)
            return false;
        else if(rank[rootA]> rank[rootB]){
            parent[rootB] = rootA;
            rank[rootA]+=rank[rootB];
        }else{
            parent[rootA] = rootB;
            rank[rootB]=rank[rootA];
        }
        
        return true;

    }
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;

    }
    public List<Integer> numIslands2(int n, int m, int[][] positions) {
        parent = new int[n*m];
        Arrays.fill(parent, -1);
        rank = new int[n*m];
        vis = new boolean[n][m];
        Arrays.fill(rank, 1);
        int cnt=0;
        List<Integer> ans = new ArrayList<>();
        int[][] directions = {{0,1}, {1,0},{0,-1},{-1,0}};
        for(int[] pos : positions){
            int i =pos[0];
            int j= pos[1];
            int index = i*m+j;
            if(vis[i][j]){
                ans.add(cnt);
                continue;
            }
            cnt++;
            vis[i][j]=true;
            for(int[] dir: directions){
                int adjI = i+dir[0];
                int adjJ = j+dir[1];
                if(isValid(adjI, adjJ, n,m) && vis[adjI][adjJ]){
                    int neighbourIdx = adjI*m+adjJ;
                    if(union(index, neighbourIdx)){
                        cnt--;
                    }
                }
            }
            ans.add(cnt);


        }
        return ans;

    }
}