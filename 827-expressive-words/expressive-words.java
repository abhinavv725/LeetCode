class Solution {

    private boolean check(String s, String w){
        int i=0, j=0;
        while(i<s.length() && j<w.length()){
            int c1=0, c2=0;
            if(s.charAt(i)!=w.charAt(j))    return false;
            char a1 = s.charAt(i);
            while(i<s.length() && a1==s.charAt(i)){
                i++;c1++;
            }
            while(j<w.length() && a1==w.charAt(j)){
                j++;c2++;
            }
            if(c1==c2)  continue;
            if(c2> c1)  return false;
            if(c1> c2 && c1<3)  return false;
        }

        return i==s.length() && j==w.length(); 
    }


    public int expressiveWords(String s, String[] words) {
        int ans=0;

        for(String w:words){
            if(check(s, w)) ans++;
        }
        return ans;
    }
}