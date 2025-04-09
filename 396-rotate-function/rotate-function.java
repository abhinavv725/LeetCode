class Solution {
    public int maxRotateFunction(int[] nums) {
        int s=0, f=0;
        for(int i=0;i<nums.length;i++){
            s+=nums[i];
            f+=(i*nums[i]);
        }
        int res=f;

        for(int i=nums.length-1;i>=1;i--){
            res=Math.max(res, s+ f - (nums.length*nums[i]));
            f=s+ f - (nums.length*nums[i]);
        }
        return res;

    }
}