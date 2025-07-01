class Solution {
    public List<String> partitionString(String s) {
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        for(char c: s.toCharArray()){
            sb.append(c);
            if(set.contains(sb.toString())){
                continue;

            }else{
                set.add(sb.toString());
                ans.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return ans;
    }
}