/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private void dfsSerialize(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("null").append(",");
            return;
        }

        sb.append(root.val).append(",");
        dfsSerialize(root.left, sb);
        dfsSerialize(root.right, sb);

    }


    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }


    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        TreeNode root = dfsDeserialize(nodes);
        return root;
    }
    int idx=0;
    private TreeNode dfsDeserialize(String[] nodes){
        if(nodes[idx].equals("null")){
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[idx]));
        idx++;
        node.left = dfsDeserialize(nodes);
        node.right = dfsDeserialize(nodes);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));