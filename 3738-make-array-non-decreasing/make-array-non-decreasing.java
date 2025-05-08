class Solution {
    public int maximumPossibleSize(int[] nums) {
        int size = nums.length, maxi = nums[0], ans=0;
        int[] temp = new int[size];
    
        for(int i=0;i<size;i++){
            maxi = Math.max(maxi, nums[i]);
            temp[i] = maxi;
        }
        for(int i=0;i<size;i++){
            if(temp[i]!=nums[i]){
                ans++;
            }
        }
        return size-ans;
    }
}