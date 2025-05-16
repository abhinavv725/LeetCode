class Solution {
    private boolean isValid(int i, int j, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        return i>=0 && j>=0 && i<n && j<m;
    }
    int[][] directions = {{-1, 0}, {0,-1}, {1,0}, {0,1}};
    public int maximumMinimumPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                        (a, b) -> Integer.compare(b[2], a[2]));
        HashSet<String> set = new HashSet<>();
        set.add("0,0");
        pq.add(new int[] {0,0, grid[0][0]});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int i = curr[0], j=curr[1], step = curr[2];
            if(i==n-1 && j==m-1){
                return step;
            }
            for(int[] dir: directions){
                int nI = i+dir[0];
                int nJ= j+dir[1];
                if(isValid(nI, nJ, grid) && !set.contains(nI+","+nJ)){
                    pq.add(new int[]{nI, nJ, Math.min(step,grid[nI][nJ])});
                    set.add(nI+","+nJ);

                }
            }
            

        }

        return ans;

    }
}