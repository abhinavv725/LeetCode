
class Solution {
    StringBuilder sb = new StringBuilder();
    private TreeNode getNode(TreeNode root, int val){
        if(root!=null){
            if(root.val==val){
                return root;
            }
            sb.append("L");
            TreeNode left = getNode(root.left, val);
            if(left!=null)  return left;
            sb.deleteCharAt(sb.length()-1);
            sb.append("R");
            TreeNode right = getNode(root.right, val);
            if(right!=null) return right;
            sb.deleteCharAt(sb.length()-1);

        }
        return null;
    }
    private TreeNode getLCA(TreeNode root, TreeNode a, TreeNode b){
        if(root!=null){
            if(root == a || root == b){
                return root;
            }
            TreeNode left = getLCA(root.left, a, b);
            TreeNode right = getLCA(root.right, a, b);
            if(left!=null && right!=null)
                return root;
            if(left!=null)  return left;
            if(right!=null) return right;

        }
        return null;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        TreeNode first = getNode(root, startValue);
        TreeNode second = getNode(root, destValue);
        TreeNode lca = getLCA(root, first, second);
        sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        getNode(lca, first.val);
        int i=0;
        while(i<sb.length()){
            ans.append('U');
            i++;
        }
        sb = new StringBuilder();
        getNode(lca, second.val);
        i=0;
        while(i<sb.length()){
            ans.append(sb.charAt(i++));
        }
        return ans.toString();


    }
}