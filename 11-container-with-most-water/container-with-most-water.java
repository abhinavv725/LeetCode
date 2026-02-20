class Solution {
    public int maxArea(int[] height) {
        int ans=0;
        int i=0, j=height.length-1;
        while(i<j){
            int width = j-i;
            int h = Math.min(height[i], height[j]);
            ans = Math.max(ans, width*h);
            if(height[i]>=height[j]){
                j--;
            }else{
                i++;
            }
        }

        return ans;
    }
}