class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> wild = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                open.add(i);
            }else if(c =='*'){
                wild.add(i);
            }else {
                if(!open.isEmpty()){
                    open.pop();
                }else if(!wild.isEmpty()){
                    wild.pop();
                }else{
                    return false;
                }
            }
        }
        while(!open.isEmpty() && !wild.isEmpty()){
            if(open.pop()> wild.pop()){
                return false;
            }
        }
        return open.isEmpty();
    }
}