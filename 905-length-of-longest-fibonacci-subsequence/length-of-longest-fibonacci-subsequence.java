class Solution {
    private int solve(int j, int k, int[] arr, HashMap<Integer, Integer> map){
        int target = arr[k]-arr[j];
        if(map.containsKey(target) && map.get(target)<j){
            return solve(map.get(target), j, arr, map)+1;
        }
        return 2;
    }
    public int lenLongestFibSubseq(int[] arr) {
        int max = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            map.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        for(int[] row: dp){
            Arrays.fill(row, 2);
        }

        for(int j=1;j<n;j++){
            for(int k=j+1;k<n;k++){
                int target = arr[k]-arr[j];
                if(map.containsKey(target) && map.get(target)<j){
                    int i=map.get(target);
                    dp[j][k]= dp[i][j]+1;
                }
                max=Math.max(max, dp[j][k]);
            }
        }
        return max >=3 ? max:0;
    }
}