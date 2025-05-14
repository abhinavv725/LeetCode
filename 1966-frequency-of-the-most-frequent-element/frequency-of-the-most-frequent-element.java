class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=0, l=0;
        long total=0;
        for(int r=0;r<nums.length;r++){
            total+=nums[r];
            while((long)(r-l+1)*nums[r]>total+k){
                total-=nums[l];
                l++;
            }
            ans =Math.max(ans, r-l+1);
        }
        return ans;
    }
}