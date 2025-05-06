class Solution {
    public int countPrimes(int n) {
        if(n<=0)
            return 0;
        boolean[] primes =  new boolean[n];
        Arrays.fill(primes, true);
        int ans=0;
        for(int i=2;i<n;i++){
            if(primes[i]){
                for(int j=2*i;j<n;j+=i){
                    primes[j]=false;
                }
                ans++;
            }
        }


        return ans;

    }
}