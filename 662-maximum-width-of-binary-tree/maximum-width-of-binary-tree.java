
class Pair {
    TreeNode node; int pos;
    Pair(TreeNode node, int pos){
        this.node=node;
        this.pos= pos;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));
        int ans=0;
        while(!q.isEmpty()){
            int size = q.size();
            int l=0, r=0;
            for(int i=0;i<size;i++){
                Pair curr = q.poll();
                if(i==0)
                    l = curr.pos;
                if(i==size-1){
                    r=curr.pos;
                }

                if(curr.node.left!=null){
                    q.add(new Pair(curr.node.left, 2*curr.pos));
                }

                if(curr.node.right!=null){
                    q.add(new Pair(curr.node.right, 2*curr.pos+1));
                }
            }
            ans =Math.max(ans, r-l+1);

        }
    return ans;

    }
}