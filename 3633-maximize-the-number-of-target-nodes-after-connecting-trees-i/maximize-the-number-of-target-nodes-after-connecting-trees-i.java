class Solution {
    private int bfs(List<List<Integer>> adj , int k, int start, int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] vis = new boolean[n];
        vis[start]=true;
        int cnt=0, dist=0;
        while(!q.isEmpty() && dist<=k){
            int size= q.size();
            while(size-- >0){
                int curr = q.poll();
                cnt++;
                for(int nei: adj.get(curr)){
                    if(!vis[nei]){
                        vis[nei]=true;
                        q.add(nei);
                    }
                }
            }
            dist++;
        }
        return cnt;
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length;
        int m=edges2.length;
        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj1.add(new ArrayList<>());
        }
        for(int i=0;i<=m;i++){
            adj2.add(new ArrayList<>());
        }
        for(int[] e: edges1){
            adj1.get(e[0]).add(e[1]);
            adj1.get(e[1]).add(e[0]);
        }
        for(int[] e: edges2){
            adj2.get(e[0]).add(e[1]);
            adj2.get(e[1]).add(e[0]);
        }
        int[] cnt1 = new int[n+1];
        for(int i=0;i<=n;i++){
            cnt1[i] = bfs(adj1, k, i, n+1);
        }
        int maxCount =0;
        for(int i=0;i<=m;i++){
            int cnt2 = bfs(adj2, k-1, i, m+1);
            maxCount = Math.max(maxCount, cnt2);
        }
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i] = cnt1[i] + maxCount;
        }
        return ans;
    }
}