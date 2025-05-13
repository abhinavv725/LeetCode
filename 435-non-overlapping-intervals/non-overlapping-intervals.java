class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans=0, i=0;
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1],b[1]));

        while(i<intervals.length){
            int[] first = intervals[i];
            int j=i+1;
            while(j<intervals.length && intervals[j][0]<first[1]){

                j++;ans++;
            }
            i=j;

        }

        return ans;
    }
}