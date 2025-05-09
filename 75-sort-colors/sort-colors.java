class Solution {
    public void sortColors(int[] nums) {
        int p0=0, p2 = nums.length-1;

        int curr=0;
        while(curr<=p2){
            if(nums[curr]==0){
                int temp = nums[p0];
                nums[p0]=0;
                nums[curr]=temp;
                p0++;
                curr++;

            }else if(nums[curr]==2){
                int temp = nums[p2];
                nums[p2]=2;
                nums[curr]=temp;
                p2--;
            }else{
                curr++;

            }
        }
    }
}