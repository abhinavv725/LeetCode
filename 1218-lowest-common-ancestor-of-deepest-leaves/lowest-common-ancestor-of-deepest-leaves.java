
class Solution {
    private class Pair {
        TreeNode node;int height;
        Pair(TreeNode node, int height){
            this.node=node;
            this.height=height;
        }
    }
    private Pair dfs(TreeNode node){
        if(node==null)
            return new Pair(null, 0);
        Pair left = dfs(node.left);
        Pair right = dfs(node.right);

        if(left.height==right.height){
            return new Pair(node, 1+left.height);
        }else if(left.height>=right.height){
            left.height+=1;
            return left;
        }else{
            right.height+=1;
            return right;
        }

    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }
}