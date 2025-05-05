class Solution {
    public int maxArea(int[] nums) {
        int l=0, r=nums.length-1;
        long ans=0;
        while(l<=r){
            int height = Math.min(nums[l], nums[r]);
            int width = r-l;
            ans = Math.max(ans,(long) (height*width));

            if(nums[l]<nums[r]){
                l++;
            }else{
                r--;
            }
        }
        return (int) ans;
    }
}