class Solution {
    private void rotateArray(int l, int r,int[] nums){
        while(r<nums.length && l<=r){
            int temp = nums[r];
            nums[r]=nums[l];
            nums[l]=temp;
            l++;r--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        rotateArray(0, n-1, nums);
        rotateArray(0, k-1, nums);
        rotateArray(k, n-1, nums);
    }
}