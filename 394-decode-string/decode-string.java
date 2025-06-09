class Solution {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n=0;
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                n = n*10 + (c-'0');
            }else if(c == '['){
                num.push(n);
                n=0;
                st.push(sb.toString());
                sb = new StringBuilder();
            }else if(c== ']'){
                int mul = num.pop();
                StringBuilder last = new StringBuilder(st.pop());
                for(int i=0;i<mul;i++){
                    last.append(sb);
                }
                sb = last;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}