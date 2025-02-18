class Solution {
    
    private boolean recursion(String pattern, int j,StringBuilder ans,boolean[] used){
        int last =  ans.charAt(ans.length()-1) - '0';
        if(j>=pattern.length())
            return true;
        if(pattern.charAt(j)==('I')){
            if(last==9){
                return false;
            }
            for(int i= last +1;i<=9 ;i++){
                if(!used[i]){
                    ans.append(i);
                    used[i]=true;
                    if(recursion(pattern, j+1, ans, used)){
                        return true;
                    }
                    ans.deleteCharAt(ans.length()-1);
                    used[i]=false;
                }
            }
        }else{
            if(last==1){
                return false;
            }
            for(int i= last-1;i>=1 ;i--){
                if(!used[i]){
                    ans.append(i);
                    used[i]=true;
                    if(recursion(pattern, j+1, ans, used)){
                        return true;
                    }
                    ans.deleteCharAt(ans.length()-1);
                    used[i]=false;
                }

            }
        }
        return false;
    }
    public String smallestNumber(String pattern) {
        
        for(int i=1;i<=9;i++){
            StringBuilder ans = new StringBuilder();
            boolean[] used = new boolean[10];
            used[i]=true;
            ans.append(i);
            if(recursion(pattern, 0, ans, used)){
                return ans.toString();
            }
            ans.deleteCharAt(ans.length()-1);
        }
        return "";
    }
}