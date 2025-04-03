class Solution {
    
    public int lastStoneWeightII(int[] stones) {
        int s=0;
        for(int i: stones){
            s+=i;
        }
        int total=(int) Math.ceil(s/2);
        boolean[] dp = new boolean[total+1];
        dp[0]=true;
        for(int stone: stones){
            for(int j=total;j>=stone;j--){
                dp[j] = dp[j] || dp[j-stone];
            }
        }
        for(int i=total;i>=0;i--){
            if(dp[i])
                return s - (2*i);
        }
        return -1;
    }
}