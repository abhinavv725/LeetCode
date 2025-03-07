class Solution {
    private void sieve(int left, int right,List<Integer> primes ){
        int[] s = new int[right+1];
        Arrays.fill(s, 1);
        s[0]=0; s[1]=0;
        for(int i=2;i<=right;i++){
            if(s[i]==1){
                if(i>=left && i<=right){
                primes.add(i);

                }
                for(long j=(long) i*i;j<=right;j+=i){
                    s[(int)j]=0;
                }
            }
        }
    }
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>();
        sieve(left, right, primes);
        
        if(primes.size()<2)
            return new int[] {-1,-1};
        int[] close = {-1, -1};
        int mini=Integer.MAX_VALUE;
        for(int i=1;i<primes.size();i++){
            int a =primes.get(i-1);
            int b=primes.get(i);
            int diff = b-a;
            if(diff < mini){
                mini=diff; close[0]=a; close[1]=b;
                if(mini<=2)
                    return close;
            }
        }
        return close;

    }
}