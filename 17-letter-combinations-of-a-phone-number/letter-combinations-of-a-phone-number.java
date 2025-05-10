class Solution {
    List<String> ans;
    HashMap<Character, String> map;
    StringBuilder sb;
    Solution(){
        ans = new ArrayList<>();
        map = new HashMap<>();
        sb = new StringBuilder();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

    }
    private void dfs(int i, String digits){
        if(i==digits.length()){
            if(sb.length()!=0)
                ans.add(sb.toString());
            return;
        }
        char curr = digits.charAt(i);
        String keys = map.get(curr);
        for(char c: keys.toCharArray()){
            sb.append(c);
            dfs(i+1, digits);

            sb.deleteCharAt(sb.length()-1);
            // dfs(i+1, digits);

        }

    }

    public List<String> letterCombinations(String digits) {
        dfs(0, digits);
        return ans;
    }
}