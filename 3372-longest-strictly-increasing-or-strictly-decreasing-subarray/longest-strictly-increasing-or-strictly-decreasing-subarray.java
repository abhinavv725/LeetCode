class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int countInc=1, countDec =1, n= nums.length;
        int temp=1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                temp++;
                countInc=Math.max(temp, countInc);
            }else{
                temp=1;
            }
        }
        temp=1;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                temp++;
                countDec=Math.max(temp, countDec);
            }else{
                temp=1;
            }
        }
        return Math.max(countInc, countDec);
    }
}