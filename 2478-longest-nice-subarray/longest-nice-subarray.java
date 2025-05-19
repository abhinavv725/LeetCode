class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans=0, l=0, curr=0;
        for(int r=0;r<nums.length;r++){
            while((curr & nums[r])!=0){
                curr = curr ^ nums[l];
                l++;
            }
            ans = Math.max(ans, r-l+1);
            curr = curr | nums[r];
        }

        return ans;
    }
}