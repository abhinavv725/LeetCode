class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length> nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m=nums1.length, n=nums2.length;
        int l=0, r=m;
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        while(l<=r){
            int partitionA = (l+r)/2;
            int partitionB = (n+m+1)/2 - partitionA;

            int maxLeftA = (partitionA==0) ? min : nums1[partitionA-1];
            int minRightA = (partitionA==m) ? max : nums1[partitionA];

            int maxLeftB = (partitionB==0) ? min : nums2[partitionB-1];
            int minRightB = (partitionB==n) ? max : nums2[partitionB];

            if(maxLeftA<=minRightB && maxLeftB<=minRightA){
                if((m+n) %2==0){
                    double ans = Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB);
                    return ans/2.0;

                }else{
                    return Math.max(maxLeftA, maxLeftB);
                }
            }else if(maxLeftA>minRightB){
                r = partitionA-1;
            }else{
                l=partitionA+1;
            }
        }
        return 0.0;
    }
}