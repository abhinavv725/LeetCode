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
    int res=0;
    private void dfs(TreeNode root, int direction, int sum){
        if(root==null)
            return;
        res=Math.max(res, sum);
        if(root.left!=null){
            dfs(root.left, 1, direction==-1 ? sum+1 : 1);
        }
        if(root.right!=null){
            dfs(root.right, -1, direction==1 ? sum+1 :1);
        }

    }
    public int longestZigZag(TreeNode root) {
        dfs(root.left, 1, 1);
        dfs(root.right, -1, 1);
        return res;
    }
}