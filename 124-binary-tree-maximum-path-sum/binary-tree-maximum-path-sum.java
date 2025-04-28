/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans=Integer.MIN_VALUE;
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int a = Math.max(0, dfs(root.left));
        int b = Math.max(0,dfs(root.right));
        ans = Math.max(ans, root.val + a + b);
        return root.val + Math.max(a,b);

    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
}