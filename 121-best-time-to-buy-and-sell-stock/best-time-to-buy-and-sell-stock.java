class Solution {
    public int maxProfit(int[] arr) {
        int mini=arr[0];
        int ans = -01;
        for(int i=0;i<arr.length;i++){
            mini=Math.min(mini, arr[i]);
            ans = Math.max(ans, arr[i]-mini);
        }
        return ans;
        
        
    }
}