class Solution {
    List<String> ans = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();
    private void dfs(int idx, String curr, String digits){
        if(idx==digits.length()){
            if(!curr.equals(""))
                ans.add(curr);
            return;
        }
        String val = map.get(digits.charAt(idx));
        for(char c: val.toCharArray()){
            dfs(idx+1, curr+c, digits);
        }
        
    }
    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(0,"", digits);
        return ans;
    }
}