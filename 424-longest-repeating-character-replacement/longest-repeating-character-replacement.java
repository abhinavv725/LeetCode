class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int ans=0;
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0)+1);
            int maxVal=0;
            for(int val: map.values()){
                maxVal = Math.max(maxVal, val);
            }

            while(l<=r && ((r-l+1) - maxVal)>k){
                char d = s.charAt(l);
                map.put(d, map.get(d)-1);
                if(map.get(d)==0)
                    map.remove(d);
                for(int val: map.values()){
                    maxVal = Math.max(maxVal, val);
                }
                l++;

            }
            ans = Math.max(ans, r-l+1);


        }
        return ans;
    }
}