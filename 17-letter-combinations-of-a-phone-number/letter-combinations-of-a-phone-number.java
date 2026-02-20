class Solution {
    List<String> ans =new ArrayList<>();
    private void combinations(int i, StringBuilder sb, String digits, HashMap<Character, String> map){
        if(i == digits.length()){
            ans.add(sb.toString());
            return;
        }
        char c = digits.charAt(i);
        String word = map.get(c);
        for(char ch: word.toCharArray()){
            sb.append(ch);
            combinations(i+1, sb, digits, map);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        combinations(0, new StringBuilder(), digits, map);
        return ans;
    }
}