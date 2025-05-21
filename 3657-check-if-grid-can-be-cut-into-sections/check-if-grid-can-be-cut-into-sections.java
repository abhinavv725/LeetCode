class Solution {
    private boolean validate(int[][] rectangles, int d){
        int gap=0;
        Arrays.sort(rectangles, (a,b) -> Integer.compare(a[d], b[d]));
        int farthest = rectangles[0][2+d];
        for(int i=1;i<rectangles.length;i++){
            int start = rectangles[i][d];
            int end = rectangles[i][2+d];
            if(farthest <= start){
                gap++;
            }
            farthest = Math.max(farthest, end);
        }
        return gap>=2;
    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return validate(rectangles, 0) || validate(rectangles , 1);
    }
}