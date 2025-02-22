
class Solution {
    private void dfs(TreeNode root, List<TreeNode> arr){
        if(root==null)
            return;
        
        dfs(root.left,arr);
        arr.add(root);
        dfs(root.right, arr);
    }
    public void recoverTree(TreeNode root) {
        List<TreeNode> arr = new ArrayList<>();
        dfs(root, arr);
        List<TreeNode> conflict = new ArrayList<>();
        for(int i=1;i<arr.size();i++){
            if(arr.get(i-1).val>arr.get(i).val){
                conflict.add(arr.get(i-1));
                conflict.add(arr.get(i));
            }
        }
        if(conflict.size()==0)
            return;
        
        int tempVal = conflict.get(0).val;
        conflict.get(0).val = conflict.get(conflict.size()-1).val;
        conflict.get(conflict.size()-1).val =tempVal;
        
    }
}