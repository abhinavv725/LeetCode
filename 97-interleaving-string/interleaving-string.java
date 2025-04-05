class Solution {
    private boolean dfs(int i, int j, int k, String s1, String s2, String s3,HashMap<String, Boolean> dp){
        if(k==s3.length())
            return true;
        boolean b1=false;
        boolean b2 = false;
        String key = i+","+j+","+k;
        if(dp.containsKey(key))
            return dp.get(key);
        if(i<s1.length() && s3.charAt(k) == s1.charAt(i)){
            b1 = dfs(i+1, j, k+1, s1, s2, s3,dp);
        }
        if(j<s2.length() && s3.charAt(k) == s2.charAt(j)){
            b2 = dfs(i, j+1, k+1, s1,s2,s3,dp);
        }
        dp.put(key, b1 || b2);
        return b1 || b2;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        HashMap<String, Boolean> dp = new HashMap<>();
        return dfs(0,0,0,s1, s2, s3, dp);

    }
}