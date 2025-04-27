class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int l=0, r=0;
        while(l<=r && r<s.length()){
            char curr = s.charAt(r);
            if(map.containsKey(curr) && map.get(curr)>=l){
                l=map.get(curr)+1;
            }
            map.put(curr, r);   
            ans =Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}