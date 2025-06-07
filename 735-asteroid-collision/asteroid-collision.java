class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int a: asteroids){
            boolean currDestroyed =false;
            while(!st.isEmpty() && st.peek()>0 && a<0){
                int c=-a;
                if(st.peek() == c){
                    st.pop();
                    currDestroyed=true;
                    break;
                }else if(st.peek() > c){
                    currDestroyed=true;
                    break;
                }else{
                    st.pop();
                }
            }
            if(currDestroyed ==false){
                st.add(a);
            }
        }
        int[] ans = new int[st.size()];
        int i=0;
        for(int s: st){
            ans[i++]=s;
        }
        return ans;
    }
}