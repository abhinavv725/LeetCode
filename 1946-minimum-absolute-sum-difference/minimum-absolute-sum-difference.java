class Solution {
    int MOD = (int) 1e9+7;
    private long findClosest(int[] sorted, int target){
        int l = 0, r = sorted.length-1;
        int res=sorted[0];
        while(l<=r){
            int mid = l+ (r-l)/2;
            
            if(Math.abs(sorted[mid]-target) < Math.abs(res-target)){
                res=sorted[mid];
            }else if(Math.abs(sorted[mid]-target) == Math.abs(res-target)){
                res=Math.min(res,sorted[mid]);
            }
            if(sorted[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return res;
    }
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int currAbs = 0, n= nums1.length;
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        long totalDiff=0;
        long maxGain = 0;
        for(int i=0;i<n;i++){
            long oriDiff = Math.abs(nums1[i]-nums2[i]);
            totalDiff = (totalDiff+oriDiff)%MOD;

            long closest = findClosest(sorted, nums2[i]);
            long newDiff = Math.abs(nums2[i]-closest);
            maxGain = Math.max(maxGain, oriDiff-newDiff);
        }
        return (int) (totalDiff - maxGain +MOD)%MOD;
    }
}