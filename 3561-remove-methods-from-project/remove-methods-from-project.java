class Solution {
    private void dfs(List<List<Integer>> adj, int k,int[] arr, int fill){
        arr[k]=fill;
        for(int nei: adj.get(k)){
            if(arr[nei]!=fill){
                dfs(adj, nei, arr, fill);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int[] arr = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        List<Integer> ans = new ArrayList<>();
        for(int[] inv : invocations){
            adj.get(inv[0]).add(inv[1]);
        }
        //infected nodes with value 2
        dfs(adj, k, arr, 2);
        for(int[] inv : invocations){
            adj.get(inv[1]).add(inv[0]);
        }
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                dfs(adj, i, arr, 1);
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                ans.add(i);
            }
        }
        return ans;

    }
}