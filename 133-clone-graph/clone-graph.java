
class Solution {
    private Node dfs(Node node, HashMap<Node, Node> map){
        if(node==null)  return null;
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node nei: node.neighbors){
            if(map.containsKey(nei)){
                newNode.neighbors.add(map.get(nei));
            }else{
                newNode.neighbors.add(dfs(nei, map));
            }
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }
}