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
    int ans;
    StringBuilder sb;
    private void find(TreeNode root){
        if(root==null)
            return;
        int len = sb.length();
        sb.append(root.val);
        if(root.left==null && root.right==null){
            ans+= Integer.parseInt(sb.toString());
        }else{
            find(root.left);
            find(root.right);

        }
        sb.setLength(len);

    }
    public int sumNumbers(TreeNode root) {
        ans = 0;
        sb= new StringBuilder();
        if(root==null)
            return 0;
        find(root);
        return ans;
        
    }
}