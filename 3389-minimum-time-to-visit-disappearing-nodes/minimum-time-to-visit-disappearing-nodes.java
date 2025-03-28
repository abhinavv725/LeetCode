class Solution {
    private void check(List<List<int[]>> adj, int i, int[] ans,int[] disappear){
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1], b[1])
        );
        pq.add(new int[] {i, 0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[1]> ans[curr[0]])
                continue;
            
            for(int[] nei: adj.get(curr[0])){
                int newTime = curr[1]+nei[1];
                if(newTime<disappear[nei[0]] && newTime < ans[nei[0]]){
                    ans[nei[0]]=newTime;
                    pq.add(new int[] {nei[0],newTime});
                }
            }
        }
    }
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges){
            adj.get(e[0]).add(new int[] {e[1], e[2]});
            adj.get(e[1]).add(new int[] {e[0], e[2]});
        }
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0]=0;
        check(adj, 0, ans,disappear );

        for(int i=0;i<n;i++){
            if(ans[i]==Integer.MAX_VALUE){
                ans[i] = -1;
            }
        }
        return ans;
    }
}