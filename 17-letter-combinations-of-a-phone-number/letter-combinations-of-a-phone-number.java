class Solution {
    List<String> ans = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();
    
    StringBuilder sb = new StringBuilder();
    private void dfs(int i, String digits){
        if(i==digits.length()){
            if(sb.length()>0){
                ans.add(sb.toString());
            }
            return;
        }
        String letter = map.get(digits.charAt(i));
        for(char c: letter.toCharArray()){
            sb.append(c);
            dfs(i+1, digits);

            sb.deleteCharAt(sb.length()-1);

        }
        

    }
    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        
        dfs(0, digits);

        return ans;
        
    }
}