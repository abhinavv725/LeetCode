class Solution {
    public int[] productExceptSelf(int[] nums) {
        long mul=1;
        int num_zero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                num_zero++;
            else
                mul*=nums[i];
        }
        
        for(int i=0;i<nums.length;i++){
            if(num_zero==0)
                nums[i]=(int)mul/nums[i];
            else if(num_zero==1)
                if(nums[i]==0)
                    nums[i]=(int)mul;
                else
                    nums[i]=0;
            else
                nums[i]=0;
        }
        return nums;
        
    }
}