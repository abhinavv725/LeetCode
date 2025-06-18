class Solution {
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    public void wallsAndGates(int[][] rooms) {
        int n = rooms.length, m=rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rooms[i][j]==0){
                    q.add(new int[] {i, j, 0});
                }
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0,-1}, {0,1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i=curr[0], j=curr[1], step = curr[2];
            for(int[] dir: directions){
                int ni = i+dir[0], nj = j+dir[1];
                if(isValid(ni, nj, n,m) && rooms[ni][nj]!=-1 && rooms[ni][nj]>step+1){
                    rooms[ni][nj]=step+1;
                    q.add(new int[] {ni, nj, step+1});
                }
            }
        }
    }
}