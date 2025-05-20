class Solution {
    private void swap(int[] arr, int l, int r){
        int temp =arr[l];
        arr[l] = arr[r];
        arr[r]=temp;
    }
    private void reverse(int[] arr, int l, int r){
        while(l<=r){
            swap(arr, l, r);
            l++;r--;
        }
    }
    public void nextPermutation(int[] nums) {
        int idx=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
        }
        if(idx!=-1){
            for(int i=n-1;i>idx;i--){
                if(nums[i]>nums[idx]){
                    swap(nums, idx, i);
                    break;
                }
            }

        }
        reverse(nums, idx+1, n-1);
    }
}

