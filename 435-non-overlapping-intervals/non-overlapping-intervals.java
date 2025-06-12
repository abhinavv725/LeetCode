class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int ans=0, end = Integer.MIN_VALUE;
        for(int[] t: intervals){
            if(t[0]>=end){
                end =t[1];
            }else{
                ans++;
            }
        }
        return ans;
    }
}