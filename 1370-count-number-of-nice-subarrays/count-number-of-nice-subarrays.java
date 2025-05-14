class Solution {
    private int subarrayAtleastKOdd(int[] nums, int k){
        int ans=0, sum=0, l=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r]%2;
            while(l<=r && sum>k){
                sum-=nums[l]%2;
                l++;
            }
            ans+=(r-l+1);
        }
        return ans;

    }
    public int numberOfSubarrays(int[] nums, int k) {

        return subarrayAtleastKOdd(nums, k) - subarrayAtleastKOdd(nums, k-1);
        
    }
}