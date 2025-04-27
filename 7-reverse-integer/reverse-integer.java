class Solution {
    public int reverse(int x) {
        if(x==-2147483648)
            return 0;
        int y = Math.abs(x);
        StringBuilder sb = new StringBuilder(String.valueOf(y)).reverse();
        long reverse = Long.parseLong(sb.toString());
        if(Integer.MAX_VALUE < reverse){
            return 0;
        }
        int q= x< 0 ?-1:1;
        return (int)(q* reverse);
    }
}