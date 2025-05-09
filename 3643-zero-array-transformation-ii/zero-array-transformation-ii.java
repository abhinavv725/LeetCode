class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int start =0;
        int end = queries.length, ans=-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(canMakeZero(mid, nums, queries)){
                ans = mid;
                end = mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    private boolean canMakeZero(int ind, int[] nums, int[][] queries){
        int[] diff = new int[nums.length+1];
        for(int i=0;i<ind;i++){
            int[] q = queries[i];

            diff[q[0]]=diff[q[0]]-q[2];
            diff[q[1]+1]=diff[q[1]+1]+q[2];
            
        }
        for(int i=1;i<diff.length;i++){
            diff[i]+=diff[i-1];
        }
        for(int i=0;i<nums.length;i++){
            if(diff[i]+nums[i]>0)
                return false;
        }
        return true;
    }
}