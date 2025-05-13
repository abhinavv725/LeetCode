class Solution {
    public int minOperations(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]==0){
                nums[i]=1;
                nums[i+1] = (nums[i+1]==0)?1:0;
                nums[i+2] = (nums[i+2]==0)?1:0;
                count++;
            }
        }
        int n = nums.length;
        if(nums[n-1]==1 && nums[n-2]==1)
            return count;
        return -1;
    }
}