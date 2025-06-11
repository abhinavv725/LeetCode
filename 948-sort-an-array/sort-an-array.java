class Solution {
    public int[] mergeSort(int[] nums){
        int n = nums.length;
        if(n<=1)    return nums;
        int mid = n/2;
        int[] l = Arrays.copyOfRange(nums, 0, mid);
        int[] r = Arrays.copyOfRange(nums, mid, n);

        l = mergeSort(l);
        r = mergeSort(r);
        return merge(l,r);
    }
    public int[] merge(int[] a, int[] b){
        int n=a.length, m=b.length;
        int[] ans = new int[n+m];
        int i=0, j=0, idx=0;
        while(i<n && j<m){
            if(a[i]<=b[j]){
                ans[idx++] = a[i++];
            }else{
                ans[idx++] = b[j++];
            }
        }
        while(i<n){
            ans[idx++] =a[i++];
        }
        while(j<m){
            ans[idx++]=b[j++];
        }
        return ans;
    }
    public int[] sortArray(int[] nums) {
        return mergeSort(nums);
    }
}