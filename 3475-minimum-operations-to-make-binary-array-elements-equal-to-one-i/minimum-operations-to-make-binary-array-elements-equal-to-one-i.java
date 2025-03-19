class Solution {
    private void flip(int i, int[] nums){
        for(int j=0;j<3;j++){
            nums[i+j] = nums[i+j] ^ 1;
        }
    }
    public int minOperations(int[] nums) {
        
        int res=0;
        for(int i=0;i<=nums.length-3;i++){
            if(nums[i]==0){
                res++;
                flip(i, nums);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                return -1;
        }
        return res;
    }
}