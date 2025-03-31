class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int maxi = Integer.MAX_VALUE;
        int[][] dist = new int [n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(dist[i], maxi);
            dist[i][i]=0;
            if(i<n){
                dist[i][i+1]=1;
            }
            if(i>1)
                dist[i][i-1]=1;
        }
        dist[x][y]=dist[y][x]=1;
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(dist[i][k]!=maxi && dist[k][j]!=maxi){
                        dist[i][j] =Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(dist[i][j]!=maxi && i!=j){
                    map.put(dist[i][j], map.getOrDefault(dist[i][j],0)+1);
                }
            }
        }
        int[] result = new int[n];
        for(int k=1;k<=n;k++){
            result[k-1] = map.getOrDefault(k, 0);
        }
        return result;

    }
}