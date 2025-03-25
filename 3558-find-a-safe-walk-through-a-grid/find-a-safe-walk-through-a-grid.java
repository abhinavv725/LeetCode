class Solution {
    private class Node {
        int i, j, cost;
        Node(int i, int j, int cost){
            this.i=i;this.j=j;this.cost=cost;
        }
    }
    private boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] dp = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        for(int[]row: dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0]=grid.get(0).get(0);
        vis[0][0]=true;
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.cost, b.cost)
        );

        pq.add(new Node(0,0,dp[0][0]));
        int[] dx = {-1, 0,1,0};
        int[] dy = {0, -1,0,1};

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int cI = curr.i, cJ = curr.j, cC=curr.cost;
            for(int i=0;i<4;i++){
                int nI = cI+dx[i];
                int nJ = cJ+dy[i];
                if(isValid(nI, nJ, n,m) && !vis[nI][nJ]){
                    pq.add(new Node(nI, nJ, cC+grid.get(nI).get(nJ)));
                    dp[nI][nJ] = Math.min(dp[nI][nJ], cC+grid.get(nI).get(nJ));
                    vis[nI][nJ]=true;
                }
            }

        }

        return dp[n-1][m-1]< health;

    }
}