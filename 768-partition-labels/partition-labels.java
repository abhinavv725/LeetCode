class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), i);
        }
        List<Integer> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int maxIndex = 0;
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            sb.append(curr);
            maxIndex = Math.max(maxIndex, map.get(curr));
            if(i==maxIndex){
                ans.add(sb.length());
                sb = new StringBuilder();
            }
            
        }
        return ans;
        
    }
}