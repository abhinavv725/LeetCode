class Solution {
    private int dfs(int employee, int[] manager, int[] time,List<List<Integer>> adj){
        int maxTime = 0;
        for(int sub: adj.get(employee)){
            maxTime=Math.max(maxTime, dfs(sub, manager, time, adj));
        }
        return time[employee]+maxTime;
    }
    public int numOfMinutes(int n, int headID, 
    int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int root=0;
        for(int i=0;i<n;i++){
            if(manager[i]==-1){
                root=i;
            }else{
                adj.get(manager[i]).add(i);
            }
        }
        return dfs(root, manager, informTime, adj);
    }
}