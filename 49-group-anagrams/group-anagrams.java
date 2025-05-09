class Solution {
    List<List<String>> ans ;
    HashMap<String, List<String>> map;
    private String sort(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        ans = new ArrayList<>();
        map = new HashMap<>();
        for(String s: strs){
            String sortedString = sort(s);
            if(!map.containsKey(sortedString)){
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(s);
        }
        for(String k: map.keySet()){
            ans.add(map.get(k));
        }

        return ans;
    }
}