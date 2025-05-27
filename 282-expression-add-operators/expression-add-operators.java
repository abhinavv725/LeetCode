class Solution {
    List<String> ans = new ArrayList<>();
    private void dfs(int idx, String path, String num, int target, long evaluated, long prev){
        if(idx==num.length()){
            if(evaluated == target){
                ans.add(path);
            }
            return;
        }

        for(int i=idx;i<num.length();i++){
            if(i!=idx && num.charAt(idx)=='0')
                break;
            
            String currSum = num.substring(idx, i+1);
            long currNum = Long.parseLong(currSum);

            if(idx == 0){
                dfs(i+1, path + currSum, num, target, currNum, currNum);
            }else{
                dfs(i+1, path + "+" + currSum, num, target, evaluated+currNum, currNum);
                dfs(i+1, path + "-" + currSum, num, target, evaluated-currNum, -currNum);

                dfs(i+1, path + "*" + currSum, num, target,
                 evaluated - prev + (prev* currNum), prev* currNum);
            }

        }

    }
    public List<String> addOperators(String num, int target) {
        dfs(0, "", num, target, 0, 0);
        return ans;
    }
}