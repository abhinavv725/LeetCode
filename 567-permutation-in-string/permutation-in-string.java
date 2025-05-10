class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())   return false;
        if(s1.equals(s2))   return true;
        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();
        for(char c: s1.toCharArray()){
            m1.put(c, m1.getOrDefault(c, 0)+1);
        }
        for(int i=0;i<s1.length();i++){
            char c = s2.charAt(i);
            m2.put(c, m2.getOrDefault(c, 0)+1);
        }
        if(m1.equals(m2))   return true;
        int i=s1.length(), k=s1.length();

        while(i<s2.length()){
            char last = s2.charAt(i-k);
            char newC = s2.charAt(i);
            m2.put(last, m2.get(last)-1);
            m2.put(newC, m2.getOrDefault(newC, 0)+1);
            if(m2.get(last)==0)
                m2.remove(last);
            if(m1.equals(m2))   return true;
            i++;

        }
        return false;


    }
}