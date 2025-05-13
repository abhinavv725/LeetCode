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
    int ans=0;
    private void dfs(TreeNode root, int currSum){
        if(root==null)
            return;
        int newSum = 10*currSum + root.val;
        if(root.right==null && root.left==null){
            ans+=newSum;
            return;
        }
        
        dfs(root.left, newSum);
        dfs(root.right, newSum);

    }
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);

        return ans;

        
    }
}