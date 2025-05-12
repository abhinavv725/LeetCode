class Solution {
    private int palindrome(int l, int r, int n, String s){
        if(l<0 || r>=n || s.charAt(l)!=s.charAt(r)){
            return 0;
        }
        return 1+palindrome(l-1, r+1, n, s);
    }
    public int countSubstrings(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int odd = palindrome(i, i, n,s);
            int even = palindrome(i, i+1, n, s);
            ans+=(even+odd);
        }

        return ans;
    }
}