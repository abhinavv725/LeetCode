class Solution {
    private double findPower(double x, long n){
        if(x==0)    return 0;
        if(n==0)    return 1;

        double res = findPower(x, n/2);
        res=res*res;
        if(n%2==1){
            res *= x;
        }
        return res;
    }
    public double myPow(double x, int n) {
        long N=n;
        double result = findPower(x, Math.abs(N));
        return (n>=0) ? result : 1/result;
    }
}