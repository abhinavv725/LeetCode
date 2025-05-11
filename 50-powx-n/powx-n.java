class Solution {
    private double find(double x, long n){
        if(x==0)    return 0;
        if(n==0)    return 1;
        
        double res = find(x, n/2);
        res=res*res;
        if(n%2==1)
            res*=x;
        return res;


    }
    public double myPow(double x, int n) {
        long N = Math.abs((long)n);
        double res = find(x, N);
        return n<0 ? 1/res : res;

    }
}