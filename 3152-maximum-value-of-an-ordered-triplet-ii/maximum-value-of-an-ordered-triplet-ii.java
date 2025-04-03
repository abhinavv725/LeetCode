class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans=0;
        int prefixMax = nums[0];
        long maxDiff=0;
        for(int i=1;i<nums.length;i++){
            
            ans = Math.max(ans,maxDiff*nums[i]);
            maxDiff = Math.max(maxDiff, prefixMax- nums[i]);

            prefixMax = Math.max(prefixMax, nums[i]);
        }
        return ans;
    }
}