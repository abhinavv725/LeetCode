class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n= colors.length;
        int l=0, res=0;

        for(int r=1;r<n+k-1;r++){
            if(colors[r%n]==colors[(r-1)%n]){
                l=r;
            }
            if(r-l+1>k){
                l++;
            }
            if(r-l+1==k)
                res++;
        }
        return res;
    }
}