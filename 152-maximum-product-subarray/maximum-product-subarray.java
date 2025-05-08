class Solution {
    public int maxProduct(int[] nums) {
        int currMax = 1, currMin=1;
        int res = Arrays.stream(nums).max().getAsInt();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                currMax = 1; currMin=1;
            }else{
                int temp = currMax;
                currMax = Math.max(nums[i], Math.max(nums[i]*currMax, nums[i]*currMin));
                currMin = Math.min(nums[i], Math.min(nums[i]*temp, nums[i]*currMin));
                res = Math.max(res,currMax );
            }
        }
        return res;
        
    }
}