class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> mp = new HashMap<>();
        HashMap<Character, Integer> ms = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        if(p.length()>s.length()){
            return ans;
        }
        for(char c: p.toCharArray()){
            mp.put(c, mp.getOrDefault(c, 0)+1);
        }
        int windowSize = p.length();
        for(int i=0;i<windowSize;i++){
            char c = s.charAt(i);
            ms.put(c, ms.getOrDefault(c, 0)+1);
        }
        if(ms.equals(mp)){
            ans.add(0);
        }
        for(int i=1;i<=s.length()-windowSize;i++){
            char old = s.charAt(i-1);
            char ne = s.charAt(i+windowSize-1);
            ms.put(old, ms.get(old)-1);
            if(ms.get(old)==0){
                ms.remove(old);
            }
            ms.put(ne, ms.getOrDefault(ne, 0)+1);
            if(ms.equals(mp)){
                ans.add(i);
            }
        }
        return ans;

    }
}