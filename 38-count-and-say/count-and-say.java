class Solution {
    private String helper(String s ){
        if(s.length()==1){
            return "1" + s.charAt(0);
        }
        StringBuilder sb = new StringBuilder();
        int count=1;
        char check = s.charAt(0);
        for(int i=1;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr == check){
                count++;
            }else{
                sb.append(count+"");
                sb.append(check);
                count=1;
                check=curr;
            }
        }
        sb.append(count+"");
        sb.append(check);
        return sb.toString();
        
    }
    public String countAndSay(int n) {
        String start = "1";
        for(int i=1;i<n;i++){
            start = helper(start);
        }

        return start;
    }
}