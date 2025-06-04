class Solution {
    List<String> ans = new ArrayList<>();
    private void dfs(int idx, long curr, int target, String num, String part, long prev){
        if(idx==num.length()){
            if(curr==target){
                ans.add(part);
            }
            return;
        }
        for(int i=idx;i<num.length();i++){
            if(i!=idx && num.charAt(idx)=='0')
                break;
            String n = num.substring(idx, i+1);
            long currNum = Long.parseLong(n);
            if(idx==0){
                dfs(i+1, currNum, target, num, n, currNum);
            }else{
                dfs(i+1, curr + currNum, target, num, part + "+" + currNum, currNum);
                dfs(i+1, curr - currNum, target, num, part + "-" + currNum, -currNum);
                dfs(i+1, (curr - prev) + (prev * currNum), target, num, part + "*" + currNum,prev* currNum);
            }
            
        }
        

    }
    public List<String> addOperators(String num, int target) {

        dfs(0, 0, target, num, "", 0);
        return ans;
    }
}