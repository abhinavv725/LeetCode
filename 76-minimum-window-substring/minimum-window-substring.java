class Solution {
    private boolean checkEqual(HashMap<Character, Integer> m1,HashMap<Character, Integer> m2 ){
        
        for(char k: m1.keySet()){
            if(m2.getOrDefault(k, 0)<m1.get(k))
                return false;
        }
        
        return true;
    }
    public String minWindow(String s, String t) {
        if(t.length()> s.length())
            return "";
        
        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();

        for(char c: t.toCharArray()){
            m1.put(c, m1.getOrDefault(c, 0)+1);
        }
        int l=0;
        String ans="";
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            if(m1.containsKey(c)){
                m2.put(c, m2.getOrDefault(c, 0)+1);
            }
            while(l<=r && checkEqual(m1, m2)){
                String temp = s.substring(l, r+1);
                if(ans.length()==0 || (r-l+1)<ans.length()){
                    ans=temp;
                }
                c = s.charAt(l);
                if(m2.containsKey(c)){
                    m2.put(c, m2.get(c)-1);
                    if(m2.get(c)==0){
                        m2.remove(c);
                    }

                }
                l++;
                
            }
        }

        return ans;
    }
}