
class Solution {
    List<List<Integer>> ans;
    private void DFS(TreeNode root, int level){
        if(level>=ans.size()){
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            ans.add(temp);
        }else{
            if(level%2==0)
                ans.get(level).add(root.val);
            else
                ans.get(level).add(0, root.val);
        }
        if(root.left!=null)
            DFS(root.left, level+1);
        if(root.right!=null)
            DFS(root.right, level+1);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ans = new ArrayList<>();
        if(root==null)  return ans;

        DFS(root, 0);
        return ans;
    }
}