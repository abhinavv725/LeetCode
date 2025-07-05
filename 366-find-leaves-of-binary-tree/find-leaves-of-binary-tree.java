
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    private TreeNode dfs(TreeNode root, List<Integer> temp){
        if(root == null)    return null;
        if(root.left == null && root.right == null){
            temp.add(root.val);
            return null;
        }
        root.left = dfs(root.left, temp);
        root.right = dfs(root.right, temp);
        return root;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        while(root!=null){
            List<Integer> temp = new ArrayList<>();
            root = dfs(root, temp);
            ans.add(temp);

        }
        return ans;
    }
}