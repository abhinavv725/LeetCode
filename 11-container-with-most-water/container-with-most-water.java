class Solution {
    int ans = 0;
    public int maxArea(int[] height) {
        int l=0, r= height.length-1;

        while(l<=r){
            int currHeight = Math.min(height[r], height[l]);
            int width = r-l;
            ans = Math.max(ans, currHeight* width);
            
            if(height[r]< height[l]){
                r--;
            }else{
                l++;
            }

        }


        return ans;
        
    }
}