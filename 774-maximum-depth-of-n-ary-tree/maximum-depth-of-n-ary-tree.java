/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int ans;
    private void dfs(Node root, int height){

        for(Node child: root.children){
            dfs(child, height+1);
        }
        ans=Math.max(height+1, ans);
    }
    public int maxDepth(Node root) {
        ans=0;
        if(root==null)
            return ans;
        dfs(root, 0);
        return ans;
    }
}