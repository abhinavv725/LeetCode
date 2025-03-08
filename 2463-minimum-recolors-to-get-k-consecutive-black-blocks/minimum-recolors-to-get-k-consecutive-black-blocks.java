class Solution {
    public int minimumRecolors(String s, int k) {
        int ans = Integer.MAX_VALUE;
        int countW =0, countB=0; 
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='B')
                countB++;
            else
                countW++;
        }
        ans = Math.min(ans, countW);
        for(int i=1;i<=s.length()-k;i++){
            char old = s.charAt(i-1);
            if(old =='W'){
                countW--;
            }else{
                countB--;
            }
            char newt = s.charAt(i+k-1);
            if(newt =='W'){
                countW++;
            }else{
                countB++;
            }
            ans = Math.min(ans, countW);

        }

        return ans;
    }
}