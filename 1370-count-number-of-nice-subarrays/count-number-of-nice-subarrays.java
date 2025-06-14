class Solution {
    private int check(int[] nums, int k){
        int l=0, s=0, ans=0;
        for(int r=0;r<nums.length;r++){
            s+=nums[r]%2;
            while(l<=r && s> k){
                s-=nums[l]%2;
                l++;
            }
            ans+=(r-l+1);
            

        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return check(nums, k) - check(nums, k-1);
    }
}