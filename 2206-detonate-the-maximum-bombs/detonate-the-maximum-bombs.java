class Solution {
    public int maximumDetonation(int[][] bombs) {
        int ans=0;
        for(int i=0;i<bombs.length;i++){
            ans=Math.max(ans, dfs(i, new boolean[bombs.length], bombs));
        }
        return ans;
        
    }
    private int dfs(int idx, boolean[] vis, int[][] bombs){
        vis[idx]=true;
        int count=1;
        int n = bombs.length;
        for(int i=0;i<n;i++){
            if(!vis[i] && inRange(bombs[idx], bombs[i])){
                count+=dfs(i, vis, bombs);
            }
        }
        return count;
    }
    private boolean inRange(int[] a, int[] b){
        long dx = a[0]-b[0], dy = a[1]-b[1], r = a[2];
        return dx*dx + dy*dy <= r*r;
    }
}