class Solution {
    public String simplifyPath(String path) {
       Stack<String> st = new Stack<>();
       String[] dir = path.split("/");
       for(String s: dir){
            if(s.equals("") || s.equals("."))
                continue;
            else if( s.equals("..")){
                if(!st.isEmpty())
                    st.pop();
            }else 
                st.push(s);
            
       } 
       StringBuilder sb = new StringBuilder();
       for(String folder: st){
        sb.append("/").append(folder);
       }

       return sb.length()==0?"/": sb.toString();
    }
}