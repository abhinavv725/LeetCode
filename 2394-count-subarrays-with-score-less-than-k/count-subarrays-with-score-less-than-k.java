class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0, sum=0;
        int l = 0, r = 0;
        while(l<=r && r<nums.length){
            sum+=nums[r];
            while(l<=r && sum * (r-l+1)>=k){
                sum-=nums[l];
                l++;
            }
            ans+=(r - l + 1);
            r++;
            
        }
        return ans;
        
    }
}