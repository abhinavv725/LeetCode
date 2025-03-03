class Solution {
    private boolean check(String q, String p){
        int n=q.length();
        int m = p.length();
        if(m>n){
            return false;
        }else if(q.equals(p)){
            return true;
        }else{
            int i=0, j=0;
            
            while(i<n && j<m){
                char a = q.charAt(i);
                char b = p.charAt(j);
                if(a == b){
                    i++;j++;
                }else if(a!=b && Character.isLowerCase(a)){
                    i++;
                }else{
                    return false;
                }
            }
            while(i<n){
                char a = q.charAt(i);
                if(Character.isUpperCase(a)){
                    return false;
                }
                i++;
            }

            if(i==n && j==m){
                return true;
            }
            return false;
        }
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();

        for(String q: queries){
            if(check(q, pattern)){
                ans.add(true);
            }else{
                ans.add(false);
            }

        }
        return ans;
    }
}