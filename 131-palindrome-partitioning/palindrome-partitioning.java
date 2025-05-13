class Solution {
    List<List<String>> ans = new ArrayList<>();
    private boolean isPalindrome(String s){
        int l=0, r=s.length()-1;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;r--;

        }
        return true;
    }
    private void dfs(int idx, String s, List<String> temp){
        if(s.length()==idx){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=idx;i<s.length();i++){
            String pre = s.substring(idx, i+1);
            if(isPalindrome(pre)){
                temp.add(pre);
                dfs(i+1,s,  temp);
                temp.remove(temp.size()-1);
            }
        }

    }   
    public List<List<String>> partition(String s) {
        
        dfs(0, s, new ArrayList<>());
        return ans;
    }
}