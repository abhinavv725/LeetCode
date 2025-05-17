class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s: tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int second =st.pop();
                int first = st.pop();
                if(s.equals("+")){
                    st.push(first+second);
                }else if(s.equals("-")){
                    st.push(first-second);
                }else if(s.equals("*")){
                    st.push(first*second);
                }else{
                    st.push(first/second);
                }

            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}