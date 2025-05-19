class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] range = {tops[0], bottoms[0]};
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<=1;i++){
            int curr = range[i];
            int tempUp =0, tempBot = 0;
            boolean valid=true;
            for(int j=0;j<tops.length;j++){
                if(tops[j]!=curr && bottoms[j]!=curr){
                    valid=false;
                    break;
                }else if(tops[j]==curr && bottoms[j]==curr){
                    continue;
                }
                else if(curr==tops[j]){
                    tempUp++;
                }else{
                    tempBot++;
                }

            }
            if(valid){
                ans = Math.min(ans, Math.min(tempUp, tempBot));
            }
        }
        return ans ==Integer.MAX_VALUE ? -1: ans;
    }
}