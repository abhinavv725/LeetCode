class Solution {
    private int sum(String s){
        int ans=0;
        for(char i: s.toCharArray()){
            ans += (i-'0');
        }
        return ans;
    }
    private boolean check(int number){
        String s = number +"";
        int n=s.length();
        if(n%2!=0){
            return false;
        }
        return sum(s.substring(0, n/2)) == sum(s.substring(n/2, n));

    }
    public int countSymmetricIntegers(int low, int high) {
        int ans=0;
        for(int i=low;i<=high;i++){
            if(check(i)){
                ans++;
            }
        }
        return ans;
    }
}