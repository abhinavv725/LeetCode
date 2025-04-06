class Solution {
    public int maxProduct(int[] nums) {
        int maxi = nums[0], mini=nums[0], res = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp = mini;
                mini=maxi;
                maxi = temp;
            }
            maxi = Math.max(nums[i], nums[i]*maxi);
            mini = Math.min(nums[i], nums[i]*mini);
            res=Math.max(maxi, res);
        }
        return res;
    }
}