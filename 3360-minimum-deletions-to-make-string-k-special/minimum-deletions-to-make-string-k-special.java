class Solution {
    int[][] dp;
    private int ans(int i, int j, int[] freq, int k){
        if(i==j || freq[j]-freq[i]<=k)    return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        return dp[i][j] = Math.min(freq[i]+ans(i+1, j, freq, k),
                                    freq[j]-freq[i]-k + ans(i, j-1, freq, k));

    }
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for(char c: word.toCharArray()){
            freq[c-'a']++;
        }
        Arrays.sort(freq);
        dp = new int[26][26];
        for(int[]r: dp){
            Arrays.fill(r, -1);
        }
        return ans(0, 25, freq, k);
    }
}