class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        int latestEnd=0;
        int n= intervals.length;
        ArrayList<int[]> arr = new ArrayList<>();
        int i=0;
        while(i<n){

            int first = intervals[i][0];
            int second = intervals[i][1];
            i++;
            while(i<n && second>=intervals[i][0]){
                second = Math.max(second,intervals[i][1]);
                i++;
            }
            arr.add(new int[] {first,second});
        }
        return arr.toArray(new int[0][]);
    }
}