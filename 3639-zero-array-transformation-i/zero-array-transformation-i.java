class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff =new int[n];
        for(int[] q: queries){
            diff[q[0]]+=1;
            if(q[1]+1<n){
                diff[q[1]+1]-=1;
            }
        }
        for(int i=1;i<n;i++){
            diff[i]+=diff[i-1];
            
        }
        for(int i=0;i<n;i++){
            if(nums[i]> diff[i])
                return false;
        }
        return true;
    }
}