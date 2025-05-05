class Solution {
    String ans ="";
    private String longest(int l, int r, String s){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1, r);

    }
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            String temp1 = longest(i, i, s);
            String temp2 = longest(i, i+1, s);

            if(temp1.length()>ans.length()){
                ans=temp1;

            }
            if(temp2.length()>ans.length()){
                ans=temp2;
                
            }

        }

        return ans;
        
    }
}