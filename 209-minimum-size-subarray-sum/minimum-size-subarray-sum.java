class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0, ans=Integer.MAX_VALUE, s=0;
        for(int r=0;r<nums.length;r++){
            s+=nums[r];
            while(l<=r && s>=target){
                ans=Math.min(ans, r-l+1);
                s-=nums[l];
                l++;
            }
        }
        return ans==Integer.MAX_VALUE ? 0: ans;
    }
}