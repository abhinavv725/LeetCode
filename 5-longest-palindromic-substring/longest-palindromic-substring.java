class Solution {
    private String check(int l, int r, int n,String s){
        if(l<0 || r>=n || s.charAt(l)!=s.charAt(r)){
            return s.substring(l+1,r);
        }
        return check(l-1, r+1,n, s);

        

    }
    public String longestPalindrome(String s) {
        
        int n = s.length();
        String ans=String.valueOf(s.charAt(0));
        for(int i=0;i<n;i++){
            String check =check(i,i, n, s);
            String check1 =check(i,i+1, n, s);
            if(check.length()>= ans.length()){
                ans=check;
            }
            if(check1.length()>= ans.length()){
                ans=check1;
            }
        }
        return ans;
    }
}