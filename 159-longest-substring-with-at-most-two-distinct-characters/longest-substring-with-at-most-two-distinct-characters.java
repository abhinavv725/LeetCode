class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int l=0, r=0;
        int ans=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(l<=r && r<s.length()){
            char c = s.charAt(r);
            if(map.size()<2 || map.containsKey(c)){
                map.put(c, r);
                ans = Math.max(ans, r-l+1);
            }else{
                char x ='a';
                int newL = s.length();
                for(char key : map.keySet()){
                    if(newL>map.get(key)){
                        newL=map.get(key);
                        x = key;
                    }
                }
                l=newL+1;
                map.remove(x);
                map.put(c, r);
                ans = Math.max(ans,r-l+1);

            }
            r++;

        }

        return ans;
    }
}