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
    private TreeNode dfs(TreeNode root, int low, int high){
        if(root==null)  return null;
        root.left = dfs(root.left, low, high);
        root.right = dfs(root.right, low, high);

        if(root.val<low)    return root.right;
        if(root.val>high)   return root.left;
        return root;
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }
}