class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        right[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(nums[i], right[i+1]);
        }
        int l=0, res=0;
        for(int r=1;r<n;r++){
            while(nums[l]>right[r]){
                l++;
            }
            res = Math.max(r-l, res);
        }
        return res;
    }
}