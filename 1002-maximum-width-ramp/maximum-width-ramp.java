class Solution {
    public int maxWidthRamp(int[] nums) {
        int ans=0, n = nums.length, l=0;
        int[] right =new int[n];
        right[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(nums[i], right[i+1]);
        }
        for(int r=1;r<n;r++){
            while(nums[l]> right[r]){
                l++;
            }
            ans=Math.max(ans, r-l);
        }


        return ans;
    }
}