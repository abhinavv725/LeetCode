class Solution {
    public int maxSubArray(int[] nums) {
        int ans=Integer.MIN_VALUE, sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            ans= Math.max(sum, ans);
            sum=Math.max(sum, 0);
        }

        return ans;
        
    }
}