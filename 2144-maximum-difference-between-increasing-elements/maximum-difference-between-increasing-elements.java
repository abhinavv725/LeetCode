class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int[] l=new int[n];
        int[] r=new int[n];
        for(int i=0;i<n;i++){
            l[i] = nums[i];
            if(i-1>=0){
                l[i] = Math.min(l[i], l[i-1]);
            }
        }
        for(int i=n-1;i>=0;i--){
            r[i] = nums[i];
            if(i+1<n){
                r[i] = Math.max(r[i], r[i+1]);
            }
        }
        int ans =-1;
        for(int i=0;i<n;i++){
            if(r[i]>l[i]){
                ans = Math.max(ans, r[i]-l[i]);
            }
        }

        return ans;
    }
}