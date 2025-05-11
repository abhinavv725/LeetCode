class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        int ans=0;

        for(int i=2;i<n;i++){
            if(primes[i]){
                ans++;
                for(int j=2*i;j<n;j+=i){
                    primes[j]=false;
                }
            }
        }
        return ans;
    }
}