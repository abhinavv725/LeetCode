class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int[] arr= new int[n];
        for(int[] q: queries){
            arr[q[0]]+=1;
            if(q[1]+1<n)
                arr[q[1]+1]-=1;
        }
        for(int i=1;i<n;i++){
            arr[i] = arr[i]+arr[i-1];
        }

        for(int i=0;i<n;i++){
            if(nums[i]>arr[i]){
                return false;
            }
        }
        return true;
    }
}