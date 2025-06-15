class Pair { 
    boolean found;
    int sum;
    Pair(int sum, boolean found){
        this.sum = sum;
        this.found=found;
    }
}
class Solution {
    TreeNode rootRef;
    private int sum(TreeNode root){
        if(root==null)  return 0;
        
        return root.val + sum(root.right) + sum(root.left);

    }
    private Pair check(TreeNode root, int target){
        if(root==null)  return new Pair(0, false);
        Pair a = check(root.left, target);
        Pair b = check(root.right, target);
        int curr= root.val + a.sum+b.sum;
        boolean found = a.found || b.found || (curr==target && root!=rootRef);
        return new Pair(curr, found);
    }
    public boolean checkEqualTree(TreeNode root) {
        this.rootRef = root;
        int s = sum(root);
        if(s%2!=0)  return false;
        int target = s/2;
        return check(root, target).found;
    }
}