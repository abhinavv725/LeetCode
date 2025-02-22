
class Solution {
    private void dfs(TreeNode root,List<Integer> nodes){
        if(root==null){
            return;
        }else{
            dfs(root.left, nodes);
            nodes.add(root.val);
            dfs(root.right,nodes);
        }
    }
    private TreeNode buildTree(List<Integer> nodes, int left, int right){
        if(left>right){
            return null;
        }
        int mid = left+(right-left)/2;
        TreeNode root = new TreeNode(nodes.get(mid));
        root.left = buildTree(nodes, left, mid-1);
        root.right = buildTree(nodes, mid+1, right);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        dfs(root, nodes);
        return buildTree(nodes, 0, nodes.size()-1);
    }
}