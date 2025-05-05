class Solution {
    private boolean isLowerLarger(double lineY, int[][] squares){
        double areaUp = 0.0;
        double areaDown = 0.0;
        for(int[] s: squares){
            int bottom = s[1];
            int side = s[2];
            int top = bottom + side;

            if(top <= lineY){
                areaDown += (double) side * side;
            } else if(bottom >= lineY){
                areaUp += (double) side * side;
            } else {
                double below =lineY - bottom;
                double above = top - lineY;
                areaDown += side * below;
                areaUp += side * above;
            }
        }
        return areaDown >= areaUp;
    }

    public double separateSquares(int[][] squares) {
        double low = Integer.MAX_VALUE;
        double high = Integer.MIN_VALUE;

        for(int[] s : squares){
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
        }

        double eps = 1e-5;

        while(high - low > eps){
            double mid = (low + high) / 2.0;
            if(isLowerLarger(mid, squares)){
                high = mid;
            } else {
                low = mid;
            }
        }

        return (low + high) / 2.0;
    }
}
