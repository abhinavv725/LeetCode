class Solution {
    
    public boolean dfs(int[] pre, int start, int end, int min, int max){
        if(start>end)   return true;
        int root = pre[start];
        if(root<=min || root>=max)  return false;
        int i=start+1;
        while(i<=end && pre[i]<root){
            i++;
        }
        return dfs(pre, start+1, i-1, min, root) && 
                dfs(pre, i, end, root, max);
    }
    
    public boolean verifyPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}