class DSU {
    int[] parent;
    int[] rank;
    DSU(int n){
        rank = new int[n];
        Arrays.fill(rank, 1);
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public boolean union(int a, int b){
        if(isConnected(a, b))
            return false;
        int rootA = find(a);
        int rootB = find(b);
        if(rank[rootA]> rank[rootB]){
            parent[rootB] = rootA;
            rank[rootA]+=rank[rootB];
        }else{
            parent[rootA] = rootB;
            rank[rootB]+=rank[rootA]; 
        }
        return true;
    }
    public int find(int a){
        if(parent[a]==a)
            return a;
        return parent[a]=find(parent[a]);
    }
    public boolean isConnected(int a, int b){
        return find(a) == find(b);
    }
}

class Solution {
    public boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    public List<Integer> numIslands2(int n, int m, int[][] positions) {
        int[][] mat = new int[n][m];
        List<Integer> ans = new ArrayList<>();
        int cnt=0;
        DSU dsu = new DSU(n*m);
        int[][] directions = {{1, 0}, {0,1}, {-1, 0}, {0,-1}};
        for(int[] pos: positions){
        
            int i=pos[0], j=pos[1];
            if(mat[i][j]==1){
                ans.add(cnt);
                continue;
            }
            mat[i][j]=1;
            cnt++;


            int a = i*m+j;
            for(int[] dir: directions){
                int ni = i+dir[0], nj = j+dir[1];
                if(isValid(ni, nj, n,m) && mat[ni][nj]==1){
                    int b = ni*m+nj;
                    if( dsu.union(a, b)){
                        cnt--;
                    }
                }
            }

            ans.add(cnt);
        }

        return ans;
    }
}