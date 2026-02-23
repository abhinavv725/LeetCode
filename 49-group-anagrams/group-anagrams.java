class Solution {
    private String sort(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
    
        for(String s:strs){
            String sorted = sort(s);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
                map.get(sorted).add(s);
            
        }
        for(String key: map.keySet()){
            ans.add(map.get(key));
        }

        return ans;
    }
}