class Solution {
    private String getReversed(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> same = new HashMap<>();
        HashMap<String, Integer> diff = new HashMap<>();

        for(String s: words){
            if(s.charAt(0)==s.charAt(1))
                same.put(s, same.getOrDefault(s, 0)+1);
            else
                diff.put(s, diff.getOrDefault(s, 0)+1);
        }
        int ans=0;
        boolean foundOne=false;
        for(String key: same.keySet()){
            int val = same.get(key);
            while(val>1){
                ans+=4;
                val-=2;
            }
            if(val==1 && !foundOne){
                foundOne=true;
                ans+=2;
                

            }
            same.put(key, val);
            
        }
        for(String key: diff.keySet()){
            String rev = getReversed(key);
            if(diff.containsKey(rev)){
                int curr = diff.get(key);
                int back = diff.get(rev);
                while(curr>0 && back>0){
                    ans+=4;
                    diff.put(key, diff.get(key)-1);
                    diff.put(rev, diff.get(rev)-1);
                    curr = diff.get(key);
                    back = diff.get(rev);
                }
            }
        }
        return ans;
    }
}