class Solution {
    Stack<int[]> st = new Stack<>();
    public int calculate(String s) {
        int sign = 1;
        int currNum =0, res=0;
        for(int i=0;i<=s.length();i++){
            if(i==s.length()){
                res = res + (currNum*sign);
                break;

            }
            char c = s.charAt(i);
            if(c==' '){
                continue;
            }else if(Character.isDigit(c)){
                currNum = 10*currNum + (c-'0');
            }else if(c == '+' || c == '-'){
                res = res + (currNum*sign);
                currNum=0;
                sign = (c == '+') ? 1: -1;
            }else if(c == '('){
                st.push(new int[] {res, sign});
                currNum=0;
                res=0;
                sign=1;
            }else if(c== ')'){
                res = res + (currNum*sign);
                currNum=0;
                int[] last = st.pop();
                res = last[0] + res*last[1];
            }
            

        }
        return res;
    }
}