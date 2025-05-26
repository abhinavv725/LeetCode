class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        if(n<2){
            return values[0] + values[1] +0 -1;
        }
        int[] suffix = new int[n];
        for(int i=n-1;i>=0;i--){
            suffix[i] = values[i]-i;
            if(i+1<n){
                suffix[i] = Math.max(suffix[i], suffix[i+1]);
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            ans = Math.max(ans, values[i] + i + suffix[i+1]);
        }
        return ans;
    }
}