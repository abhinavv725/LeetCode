class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                int n = sb.length();
                sb.deleteCharAt(n-1);
                
            }else
                sb.append(s.charAt(i));
        }
        String result = sb.toString().trim();
        return result;
    }
}