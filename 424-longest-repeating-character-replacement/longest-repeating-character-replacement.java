class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, ans=0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int r=0;r<s.length();r++){
            char right = s.charAt(r);
            map.put(right, map.getOrDefault(right, 0)+1);
            int maxCount=0;
            for(int val : map.values()){
                maxCount = Math.max(maxCount, val);
            }
            while((r-l+1)-maxCount>k){
                char left = s.charAt(l);
                map.put(left, map.getOrDefault(left, 0)-1);
                for(int val : map.values()){
                    maxCount = Math.max(maxCount, val);
                }

                l++;
            }
            ans= Math.max(ans, r-l+1);


        }
        return ans;
    }
}