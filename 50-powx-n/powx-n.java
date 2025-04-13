class Solution {
    private double pow(double x, long n){
        if(n==0)
            return 1;
        
        double half = pow(x, n/2);
        double res = half*half;
        if(n%2==1){
            res =res*x;
        }
        return res;
    }
    public double myPow(double x, int n) {
        long N =n;
        if(N<0){
            x=1/x;
            N= -N;
        }
        return pow(x, N);
    }
}