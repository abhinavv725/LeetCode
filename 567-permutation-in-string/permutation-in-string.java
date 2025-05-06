class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()> s2.length())
            return false;
        HashMap<Character, Integer> m1 = new HashMap<>();
        for(char c: s1.toCharArray()){
            m1.put(c, m1.getOrDefault(c, 0)+1);
        }
        HashMap<Character, Integer> m2 = new HashMap<>();
        int l=0, r = s1.length();
        
        for(int i=0;i<r;i++){
            char c = s2.charAt(i);
            m2.put(c, m2.getOrDefault(c, 0)+1);
        }
        if(m1.equals(m2))
            return true;
        while(l<=r && r<s2.length()){
            
            char newC = s2.charAt(r);
            char oldC =s2.charAt(l);
            m2.put(newC, m2.getOrDefault(newC, 0)+1);
            m2.put(oldC, m2.get(oldC)-1);
            if(m2.get(oldC)==0){
                m2.remove(oldC);
            }


            if(m1.equals(m2))
                return true;
            l++;r++;
            
        }
        return false;
    }
}