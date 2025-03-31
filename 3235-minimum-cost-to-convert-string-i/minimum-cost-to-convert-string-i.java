class Solution {
    public long minimumCost(String source, String target, char[] original, 
    char[] changed, int[] cost) {
        long maxi = Long.MAX_VALUE;
        long[][] grid = new long[26][26];
        for(long[] r: grid){
            Arrays.fill(r, maxi);
        }
        for(int i=0;i<original.length;i++){
            int nO = original[i]-'a';
            int nC = changed[i] -'a';
            
            // grid[nO][nC] = cost[i];
            grid[nO][nC] = Math.min(grid[nO][nC],cost[i]);
            
        }
        for(int i=0;i<26;i++){
            grid[i][i] =0;
        }
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(grid[i][k]!=maxi && grid[k][j]!=maxi && grid[i][k]+grid[k][j] < maxi){
                        grid[i][j] = Math.min(grid[i][j], grid[i][k]+grid[k][j]);
                    }
                }
            }
        }
        long ans =0;
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)!=target.charAt(i)){
                int x = source.charAt(i)-'a';
                int y = target.charAt(i)-'a';
                if(grid[x][y]==maxi)
                    return -1;
                ans+=grid[x][y];
            }
        }
        return ans;
    }
}