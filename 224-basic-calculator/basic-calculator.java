class Solution {
    public int calculate(String s) {
        Stack<int[]> st = new Stack<>();
        int curr=0;
        int sign = 1; //-1 or 1
        int res=0;
        for(int i=0;i<=s.length();i++){
            if(i==s.length()){
                res+= (curr*sign);
                break;
            }
            char c = s.charAt(i);
            if(c==' '){
                continue;
            }else if(c== '+' || c=='-'){
                res += curr *sign;
                curr = 0;
                sign = (c=='+') ?1 :-1;
            }else if(Character.isDigit(c)){
                curr = curr *10 + (c-'0');
            }else if(c=='('){
                st.push(new int[] {res, sign});
                res=0;
                sign =1;
                curr=0;
            }else{
                int[] last = st.pop();
                res += (curr*sign);
                curr=0;
                res = last[0] +res*last[1];
            }

        }
        return res;
    }
}