class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n=tops.length;
        int ans =Integer.MAX_VALUE;
        for(int i=1;i<=6;i++){
            int temp_bottom =0;
            int temp_top =0;
            boolean worked=true;
            for(int j=0;j<n;j++){
                if(tops[j]==i || bottoms[j]==i){
                    if(tops[j]==i && bottoms[j]==i)
                        continue; 
                    if(bottoms[j]==i){
                        temp_bottom++;
                    }
                    if(tops[j]==i){
                        temp_top++;
                    }
                }else{
                    worked=false;
                    break;
                }
            }
            if(worked){
                ans = Math.min(ans, Math.min(temp_top, temp_bottom));
            }
        }
        return ans == Integer.MAX_VALUE ? -1: ans;
    }
}