class Solution {
    private String change(int num, int x, int y){
        char[] n = String.valueOf(num).toCharArray();
        for(int i=0;i<n.length;i++){
            if(n[i] -'0'==x){
                n[i] = (char) ('0'+y);
            }
        }
        return new String(n);
    }
    public int maxDiff(int num) {
        int maxi = num, mini = num;
        for(int x=0;x<=9;x++){
            for(int y=0;y<=9;y++){
                String res = change(num, x, y);
                if(res.charAt(0)!='0'){
                    maxi = Math.max(maxi, Integer.parseInt(res));
                    mini = Math.min(mini, Integer.parseInt(res));
                }
            }
        }
        return maxi-mini;
    }
}