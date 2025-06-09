class Solution {
    private int getMax(HashMap<Character, Integer> map ){
        int maxi = Integer.MIN_VALUE;
        for(int val: map.values()){
            maxi = Math.max(maxi, val);
        }

        return maxi;
    }
    public int characterReplacement(String s, int k) {
        int ans=0,l=0;
        HashMap<Character, Integer> map = new HashMap<>(); 
        for(int r=0;r<s.length();r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            int count = getMax(map);
            while(l<=r && (r-l+1)-count>k){
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0)-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(l);
                }
                count = getMax(map);
                l++;

            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}