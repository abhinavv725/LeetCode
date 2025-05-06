class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeros=0;
        int prod =1;
        for(int n: nums){
            if(n==0)
                zeros++;
            else
                prod*=n;
        }
        int[] ans =new int[nums.length];
        if(zeros>=2){
            return ans;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                ans[i]=prod;
            }else{
                ans[i] = (zeros == 1) ? 0 : prod/nums[i];
            }
        }
        return ans;
    }
}