class Solution {
    public int maxArea(int[] height) {
        int l=0, r=height.length-1;
        int ans= 0;
        while(l<=r){
            int h = Math.min(height[l], height[r]);
            int width =  r-l;
            ans =Math.max(ans, h*width);
            if(height[l]> height[r]){
                r--;
            }else{
                l++;
            }
        }
        return ans;
    }
}