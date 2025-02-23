
class Solution {
    private class Pair {
        TreeNode child; TreeNode parent;
        Pair (TreeNode child, TreeNode parent){
            this.child=child;
            this.parent=parent;
        }
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, new TreeNode(-1)));

        while(!q.isEmpty()){
            int n=q.size();
            HashMap<TreeNode, Integer> map = new HashMap<>();
            int total = 0;
            Queue<Pair> temp = new LinkedList<>();
            while(n--!=0){
                Pair p = q.poll();
                TreeNode parent = p.parent;
                TreeNode curr = p.child;
                total+=curr.val;
                if(map.containsKey(parent)){
                    map.put(parent, map.get(parent)+curr.val);
                }else{
                    map.put(parent, curr.val);
                }
                temp.add(p);
                if(curr.left!=null){
                    q.add(new Pair(curr.left, curr));
                }
                if(curr.right!=null){
                    q.add(new Pair(curr.right, curr));

                }
            }
            n= temp.size();
            while(n--!=0){
                Pair p = temp.poll();
                TreeNode parent = p.parent;
                TreeNode curr = p.child;
                curr.val = total - map.get(parent);
            }
        }

        return root;
    }
}