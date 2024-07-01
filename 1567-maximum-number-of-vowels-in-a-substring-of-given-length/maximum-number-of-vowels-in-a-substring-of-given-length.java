class Solution {
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch); // Convert the character to lowercase for case insensitivity
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    
    
    public int maxVowels(String s, int k) {
        int ans=0,n=s.length(),win=0;
        
        
        for(int i=0;i<k;i++){
            if(isVowel(s.charAt(i)))
                win++;
        }
         ans=win;
        
        for(int i=k;i<n;i++){
            
            if(isVowel(s.charAt(i-k)))
                win--;
            if(isVowel(s.charAt(i)))
                win++;
            ans=Math.max(win,ans);
        }
        
        return ans;
        
    }
}