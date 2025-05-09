class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int idx=0;
        while(idx<nums.length-1){
            if(nums[idx]!=nums[idx+1]){
                return nums[idx];
            }
            idx+=3;
        }

        return nums[nums.length-1];
    }
}