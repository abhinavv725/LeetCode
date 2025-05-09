
class Solution {
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return null;
        if(root == p || root == q)
            return root;
        
        TreeNode x = dfs(root.left, p, q);
        TreeNode y = dfs(root.right, p, q);
        if(x!=null && y!=null)
            return root;
        if(x!=null)
            return x;
        if(y!=null)
            return y;
        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }
}