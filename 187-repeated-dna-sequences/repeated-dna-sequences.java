class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public List<String> findRepeatedDnaSequences(String s) {
        for(int i=10;i<s.length()+1;i++){
            int j=i-10;
            String curr = s.substring(j, i);
            map.put(curr, map.getOrDefault(curr, 0)+1);
        }
        List<String> ans = new ArrayList<>();
        for(String key: map.keySet()){
            if(map.get(key)>=2)
                ans.add(key);
        }
        return ans;
    }
}