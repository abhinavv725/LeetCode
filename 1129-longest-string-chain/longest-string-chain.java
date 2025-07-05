class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    HashMap<String, Integer> dp = new HashMap<>();
    int ans= 0;

    private int dfs(int i, String[] words){
        String w = words[i];
        int len=1;
        if(dp.containsKey(w)){
            return dp.get(w);
        }
        for(int j=0;j<w.length();j++){
            String n = w.substring(0, j) + w.substring(j+1, w.length());
            if(map.containsKey(n)){
                len = Math.max(len, 1+dfs(map.get(n), words));
            }
        }
        dp.put(w, len);
        return len;
    }

    public int longestStrChain(String[] words) {
        for(int i=0;i<words.length;i++){
            map.put(words[i], i);
        }
        int temp=0;
        for(String word: words){
           temp = Math.max(temp,dfs(map.get(word), words)) ;
        }
        return temp;

    }
}