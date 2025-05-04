class Solution {
    private String shift(String s){
        StringBuilder sb = new StringBuilder("a");
        int x = s.charAt(0)-'a';
        for(int i=1;i<s.length();i++){
            int temp = (s.charAt(i) - (char) x + 26)%26;
            sb.append(temp );
        }
        return sb.toString();
    }
    public List<List<String>> groupStrings(String[] strings) {
       List<List<String>>  ans = new ArrayList<>();
       HashMap<String, List<String>> map = new HashMap<>();
       for(String s: strings){
            String temp = shift(s);
            if(!map.containsKey(temp)){
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(s);
       }
       for(String k:map.keySet()){
        ans.add(map.get(k));
       }
       return ans;
    }
}