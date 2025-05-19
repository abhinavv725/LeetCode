class Solution {
    private boolean canBeExpressed(String a, String b){
        int i=0, j=0;
        int n =a.length(), m=b.length();
        while(i<n && j<m){
            if(a.charAt(i)!=b.charAt(j)){
                return false;
            }
            int aStart =i;
            int bStart=j;
            while(i<n && a.charAt(i)==a.charAt(aStart))
                i++;
            
            while(j<m && b.charAt(j)==b.charAt(bStart))
                j++;
            int aCount = i-aStart;
            int bCount = j-bStart;
            if(bCount>aCount)
                return false;
            if (aCount != bCount && aCount < 3) return false;

            
        }
        return i==n && j==m;
    }
    public int expressiveWords(String s, String[] words) {
        int ans=0;
        for(String word: words){
            if(canBeExpressed(s, word)){
                ans++;
            }
        }
        return ans;
    }
}