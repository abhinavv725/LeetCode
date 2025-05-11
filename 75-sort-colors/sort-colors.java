class Solution {
    public void sortColors(int[] nums) {
        int i0 =0;
        int i2 = nums.length-1, curr=0;

        while(curr<=i2){
            if(nums[curr]==0){
                int temp=nums[i0];
                nums[i0] =0;
                nums[curr]=temp;
                i0++;
                curr++;
            }else if(nums[curr]==2){
                int temp=nums[i2];
                nums[i2] =2;
                nums[curr]=temp;
                i2--;
            }else{
                curr++;
            }
        }
    }
}