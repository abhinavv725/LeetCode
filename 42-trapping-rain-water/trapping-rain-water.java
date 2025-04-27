class Solution {
    public int trap(int[] height) {
        int n= height.length;
        int[] preRight = new int[n];
        int[] preLeft = new int[n];
        int ans=0;
        preRight[0] = height[0];
        preLeft[n-1] = height[n-1];
        for(int i=1;i<n;i++){
            preRight[i] = Math.max(height[i], preRight[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            preLeft[i] = Math.max(height[i], preLeft[i+1]);
        }

        for(int i=0;i<n;i++){
            ans += (Math.min(preLeft[i], preRight[i])-height[i]);
        }
        return ans;
    }
}