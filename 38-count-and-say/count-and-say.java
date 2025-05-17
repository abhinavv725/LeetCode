class Solution {
    private String buildRLE(String s){
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<s.length()){
            int count=1;
            while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                i++;
                count++;
            }
            sb.append(count).append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
    public String countAndSay(int n) {
        String s = "1";
        while(--n >0){
            s = buildRLE(s);
        }
        return s;
    }
}