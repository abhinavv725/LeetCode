class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxi =0;
        for(int n: nums){
            maxi=Math.max(n, maxi);
        }
        int l=0, count=0;
        long ans=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==maxi)
                count++;
            while(l<=r && count>=k){
                if(nums[l]==maxi)
                    count--;
                l++;
                
            }
            ans+=l;
            
        }
        return ans;
    }
}