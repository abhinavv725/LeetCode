class Solution {
    public int numberOfSubstrings(String s) {
        int res=0;
        int l=0, r=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        while(r<len){
            char n = s.charAt(r);
            map.put(n, map.getOrDefault(n,0)+1);
            while(map.size()==3){
                res += len-r;
                char old = s.charAt(l);
                    map.put(old, map.get(old)-1);
                    if(map.get(old)==0)
                        map.remove(old);
                    l++;
            }
            r++;
        }

        return res;
        
    }
}