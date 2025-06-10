class Solution {
    public int maxDifference(String s) {
       HashMap<Character, Integer> map = new HashMap<>();
       for(char c: s.toCharArray()){
        map.put(c, map.getOrDefault(c, 0)+1);
       }
       int ans =Integer.MIN_VALUE;
       for(int v1: map.values()){
        for(int v2: map.values()){
            if(v1%2!=0 && v2%2==0){
                ans=Math.max(ans, v1-v2);
            }
        }
       }
       return ans;

    }
}