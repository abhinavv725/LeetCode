class Solution {
    List<String> ans;
    private void generateBrackets(StringBuilder sb, int open, int close){
        if(open==0 && close==0){
            ans.add(new String(sb.toString()));
            return;
        }
        if(open>0){
            sb.append("(");
            generateBrackets(sb, open-1, close);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close>open){
            sb.append(")");
            generateBrackets(sb, open, close-1);
            sb.deleteCharAt(sb.length()-1);

        }

    }
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generateBrackets(new StringBuilder() , n,n);
        return ans;
    }
}