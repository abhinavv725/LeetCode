
class Solution {
    int max=0;
    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftpath = dfs(root.left);
        int rightpath = dfs(root.right);
        int left=0, right=0;

        if(root.left!=null && root.left.val == root.val){
            left=leftpath+1;
        }
        if(root.right!=null && root.right.val==root.val){
            right=rightpath+1;
        }
        max=Math.max(max, left+right);
        return Math.max(left, right);
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null){
            return 0;
        }

        dfs(root);
        return max;
        
    }
}