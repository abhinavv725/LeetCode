class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        for(char t: s.toCharArray()){
            if(Character.isDigit(t)){
                st.pop();
            }else{
                st.add(t);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c: st){
            sb.append(c);
        }
        return sb.toString();
    }
}