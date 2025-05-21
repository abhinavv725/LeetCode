class Solution {
    private boolean isMatch(HashMap<Character, Integer> m1, HashMap<Character, Integer> m2){
        for(char c: m1.keySet()){
            if(!m2.containsKey(c) || m2.get(c) < m1.get(c)){
                return false;
            } 
        }
        return true;
    }
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();
        for(char c: t.toCharArray()){
            m1.put(c, m1.getOrDefault(c, 0)+1);
        }
        int l=0; 
        String ans ="";
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            if(m1.containsKey(c))
                m2.put(c, m2.getOrDefault(c, 0)+1);
            
            while(l<=r && isMatch(m1, m2)){
                if(ans.length() == 0 || (r-l+1) < ans.length()){
                    ans = s.substring(l, r+1);
                }
                char x = s.charAt(l);
                if(m1.containsKey(x)){
                    m2.put(x, m2.get(x)-1);
                    if(m2.get(x)==0){
                        m2.remove(x);
                    }
                }
                l++;
            }
        }

        return ans;
    }
}