class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, ans=0, sum=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];

            while((r-l+1)-sum>k){
                sum-=nums[l];
                l++;
            }
            ans=Math.max(ans, r-l+1);

        }
        return ans;
    }
}