class Solution {
    public String simplifyPath(String path) {
        String[] structure = path.split("/");
        int i=0;
        Stack<String> st = new Stack<>();
        while(i<structure.length){
            if(structure[i].equals("") || structure[i].equals(".")){
                
            }else if(structure[i].equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(structure[i]);
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for(String s: st){
            sb.append("/").append(s);
        }
        return sb.length()==0 ?"/": sb.toString();
    }
}