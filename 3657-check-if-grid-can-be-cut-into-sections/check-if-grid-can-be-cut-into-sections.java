class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return check(rectangles, 0) || check(rectangles, 1);
    }
    private boolean check(int[][] rectangles, int d){
        int gap=0;
        Arrays.sort(rectangles, (a,b)-> Integer.compare(a[d], b[d]));

        int farthest = rectangles[0][d+2];
        for(int i=1;i<rectangles.length;i++){
            int[] rect = rectangles[i];
            if(farthest <=rect[d]){
                gap++;
            }
            farthest = Math.max(farthest, rect[d+2]);
        } 
        return gap>=2;
    }
}