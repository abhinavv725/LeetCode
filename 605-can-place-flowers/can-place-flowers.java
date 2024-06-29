class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0)
            return true;
        int l = flowerbed.length;
        for(int i=0;i<l;i++){
            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==l-1 || flowerbed[i+1]==0)){
                flowerbed[i]=1;
                n-=1;
                if(n==0)
                    return true;
            }
        }
        return false;
    }
}