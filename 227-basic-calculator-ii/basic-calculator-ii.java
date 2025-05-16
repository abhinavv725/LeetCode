class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int result=0, num=0;
        char lastOperator='+';
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num=10*num+(ch-'0');
            }
            if(!Character.isDigit(ch) && ch !=' ' || i==s.length()-1 ){
                if(lastOperator == '+'){
                    st.push(num);
                }
                else if(lastOperator == '-'){
                    st.push(-num);
                }
                else if(lastOperator == '*'){
                    st.push(st.pop()*num);
                }
                else{
                    st.push(st.pop()/num);
                }
                lastOperator = ch;
                num=0;

            }

            
        }
        while(!st.isEmpty()){
            result += st.pop();
        }

        return result;
    }
}