class Solution {
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        if(n==1){
            ans.add(0);
            return ans;
        }

        int[] degree = new int[n]; 

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<n;i++){
            if(degree[i]==1)
                q.add(i);
        }
        while(n>2){
            int sz = q.size();
            n-=sz;
            while(sz--!=0){
                int ele = q.poll();
                for(int nei: adj.get(ele)){
                    degree[nei]--;
                    if(degree[nei]==1)
                        q.add(nei);
                }
            }
        }
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        return ans;
    }
}