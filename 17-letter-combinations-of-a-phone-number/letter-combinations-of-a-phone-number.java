class Solution {
    List<String> ans = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();

    public Solution() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    private void dfs(int i, String digits, StringBuilder sb){
        if(i==digits.length()){
            ans.add(sb.toString());
            return;
        }
        String possible = map.get(digits.charAt(i));
        for(char d: possible.toCharArray()){
            sb.append(d);
            dfs(i+1, digits, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length()==0)
            return ans;
        dfs(0,digits, new StringBuilder());

        return ans;
    }
}