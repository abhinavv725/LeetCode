/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node clone(Node node, HashMap<Node, Node>map){
        if(node==null)
            return null;
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node nei: node.neighbors){
            if(map.containsKey(nei)){
                newNode.neighbors.add(map.get(nei));
            }else{
                newNode.neighbors.add(clone(nei, map));
            }
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        return clone(node, map);
    }
}