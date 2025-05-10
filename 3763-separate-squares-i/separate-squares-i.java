class Solution {
    private boolean isLowerlarge(double mid,int[][] squares){
        double areaBelow=0.0, areaUp=0.0;
        for(int[]s: squares){
            if(s[1]>=mid){
                areaUp+=(double) s[2]*s[2];
            }else if(s[1]+s[2]<=mid){
                areaBelow+= (double)s[2]*s[2];
            }else{
                int bottom = s[1];
                int top = s[1]+s[2];
                int side = s[2];
                double above=top-mid;
                double below = mid-bottom;
                areaUp += side* above;
                areaBelow+= side*below;
            }

        }

        return areaBelow>=areaUp;

    }
    public double separateSquares(int[][] squares) {
        double high = Integer.MIN_VALUE;
        double low = Integer.MAX_VALUE;
        for(int[]s:squares){
            high = Math.max(high, s[1]+s[2]);
            low = Math.min(low, s[1]);
        }
        while(high-low > 1e-5){
            double mid = (high+low)/2.0;
            if(isLowerlarge(mid, squares)){
                high=mid;
            }else{
                low=mid;
            }

        }
        return high;

    }
}