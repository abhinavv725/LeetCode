class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        // Arrays.sort(arr);
        int  ans=1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: arr){
            int x = n-difference;
            int l = map.getOrDefault(x, 0)+1;
            map.put(n, l);
            ans=Math.max(ans, l);
        }
        // int[] dp = new int[n];
        // Arrays.fill(dp, 1);
        // for(int i=n-1;i>=0;i--){
        //     for(int j=i+1;j<n;j++){
        //         if(arr[j]-arr[i]==difference){
        //             dp[i] = Math.max(dp[i], 1+dp[j]);
        //         }
        //     }
        // }
        // return Arrays.stream(dp).max().getAsInt();
        return ans;
    }
}