class Solution {
    int res=Integer.MIN_VALUE;
    private void solve(int i,int prevCompare, int len, int[]arr){
        if(i==arr.length){
            res=Math.max(res, len);
            return;
        }
        int comp = Integer.compare(arr[i-1], arr[i]);
        if(comp==0){
            res=Math.max(res, len);

            solve(i+1, 0, 1, arr);
        }else if(prevCompare ==0 || comp*prevCompare ==-1){
            res=Math.max(res, len);

            solve(i+1, comp, len+1, arr);
            
        }else{
            res=Math.max(res, len);

            solve(i+1, comp, 2, arr);
        }
    }   
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length==1)
            return 1;
        solve(1, 0, 1, arr);
        return res;
    }
}