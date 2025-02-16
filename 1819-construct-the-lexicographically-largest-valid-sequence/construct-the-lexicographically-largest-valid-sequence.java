class Solution {
    private boolean solve(int i, int n, int[] ans, boolean[] used){
        if(i>=ans.length)
            return true;
        if(ans[i]!=-1){
            return solve(i+1, n, ans, used);
        }
        for(int num=n;num>=1;num--){
            if(used[num])
                continue;
            used[num]=true;
            ans[i]=num;

            if(num==1){
                if(solve(i+1, n, ans, used))
                    return true;

            }else{
                int j = ans[i]+i;
                if(j<ans.length && ans[j]==-1){
                    ans[j]=num;
                    if(solve(i+1, n, ans, used)){
                        return true;
                    }
                    ans[j]=-1;
                }
            }


            used[num]=false;
            ans[i]=-1;
            
        }
        return false;
    }
    public int[] constructDistancedSequence(int n) {
        int size = (2*n)-1;
        int[] ans =new int[size];
        Arrays.fill(ans, -1);
        boolean[] used= new boolean[n+1];
        solve(0,n, ans, used);
        return ans;
    }
}