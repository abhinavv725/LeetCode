class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int ans=Integer.MAX_VALUE;

        int[] range = new int[]{tops[0], bottoms[0]};

        for(int i=0;i<=1;i++){
            int tempTop=0, tempBottom=0;
            boolean failed = false;
            for(int j=0;j<tops.length;j++){
                if(tops[j]!=range[i] && bottoms[j]!=range[i]){
                    failed =true;
                    break;
                }
                if(tops[j]==range[i] && bottoms[j]==range[i]){
                    continue;
                }
                if(tops[j]==range[i])   tempTop++;
                if(bottoms[j]==range[i])   tempBottom++;
            }
            if(!failed){
                ans = Math.min(tempTop,tempBottom);
            }

        }
        
        return (ans == Integer.MAX_VALUE) ? -1: ans;
    }
}