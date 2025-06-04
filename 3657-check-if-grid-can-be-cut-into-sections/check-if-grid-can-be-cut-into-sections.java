class Solution {
    public boolean disect(int[][] rect, int d){
        int[][] intervals = new int[rect.length][2];

        for(int i=0;i<rect.length;i++){
            intervals[i][0]=rect[i][d];
            intervals[i][1]=rect[i][d+2];
        }
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        int farthest = intervals[0][1];
        int i=1, gaps=0;
        while(i<intervals.length){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(farthest <= start){
                gaps++;
            }
            farthest=Math.max(farthest, end);
            i++;
        }
        return gaps>=2;
    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return disect(rectangles, 0) || disect(rectangles, 1);
    }
}