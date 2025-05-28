/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    HashSet<Node> set = new HashSet<>();
    private Node findParent(Node a){
        while(a!=null){
            if(set.contains(a)){
                return a;
            }
            set.add(a);
            a=a.parent;
        }
        return null;
    }
    public Node lowestCommonAncestor(Node p, Node q) {
        findParent(p);
        return findParent(q);
    }
}