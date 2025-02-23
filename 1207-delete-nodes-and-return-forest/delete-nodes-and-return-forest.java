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
    List<TreeNode> ans ;
    Set<Integer> map;
    private TreeNode dfs(TreeNode root, boolean hasParent){
        if(root==null ){
            return null;
        }
        boolean shouldDelete = map.contains(root.val);
        if(shouldDelete == false && hasParent == false){
            ans.add(root);
        }
        
        root.left=dfs(root.left, !shouldDelete);
        root.right=dfs(root.right, !shouldDelete);
        return shouldDelete ? null : root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        map = new HashSet<>();
        for(int i: to_delete){
            map.add(i);
        }
        dfs(root,false);
        return ans;
        
    }
}