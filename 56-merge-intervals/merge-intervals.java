class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        int i=0;
        while(i<intervals.length){
            int[] first = intervals[i];
            int j=i+1;
            while(j<intervals.length && first[1]>=intervals[j][0]){
                first[1] = Math.max(first[1],intervals[j][1]);
                j++;
            }
            ans.add(first);
            i=j;
        }
        return ans.toArray(new int[0][]);
    }
}