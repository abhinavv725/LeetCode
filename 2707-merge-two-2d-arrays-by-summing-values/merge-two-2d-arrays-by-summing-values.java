class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> ans = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;
        int i=0, j=0;
        while(i< n && j<m){
            if(nums1[i][0]==nums2[j][0]){
                ans.add(new int[] {nums1[i][0], nums1[i][1]+nums2[j][1]});
                i++;j++;
            }else if(nums1[i][0]>nums2[j][0]){
                ans.add(new int[] {nums2[j][0], nums2[j][1]});
                j++;
            }else{
               ans.add(new int[] {nums1[i][0], nums1[i][1]});
                i++; 
            }
        }
        while(i<n){
            ans.add(new int[] {nums1[i][0], nums1[i][1]});
                i++; 
        }
        while(j<m){
            ans.add(new int[] {nums2[j][0], nums2[j][1]});
                j++;
        }
        return ans.toArray(new int[0][]);
    }
}