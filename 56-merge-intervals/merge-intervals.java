class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();
        int first=intervals[0][0], last=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int second = intervals[i][0], secondLast = intervals[i][1];
            if(last>=second){
                first = Math.min(first, second);
                last = Math.max(last, secondLast);
            }else{
                ans.add(new int[] {first, last});
                first = second;
                last = secondLast;
            }
        }
                ans.add(new int[] {first, last});


        return ans.toArray(new int[ans.size()][]);
    }
}