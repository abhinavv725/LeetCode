class Solution {
    private boolean check(int num, int target){
        if(target> num || target<0){
            return false;
        }
        if(target==num)
            return true;
        else{
            return check(num/10, target-(num%10)) || 
            check(num/100, target-(num%100)) ||
            check(num/1000, target-(num%1000)) ;
        }


    }
    public int punishmentNumber(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            int sq = i*i;
            if(check(sq, i)){
                ans+=sq;
            }
        }
        return ans;
    }
}