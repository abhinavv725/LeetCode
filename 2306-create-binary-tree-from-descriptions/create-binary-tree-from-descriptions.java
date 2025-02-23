
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int[] node: descriptions){
            if(!map.containsKey(node[0]))
                map.put(node[0], new TreeNode(node[0]));

            if(!map.containsKey(node[1]))
                map.put(node[1], new TreeNode(node[1]));
            set.add(node[1]);
        }
        TreeNode root = new TreeNode(-1);
        for(int[] node: descriptions){
            if(!set.contains(node[0])){
                root = map.get(node[0]);
                break;
            }
        }

        for(int[] node: descriptions){
            if(node[2]==1){
                map.get(node[0]).left = map.get(node[1]);
            }else{
                map.get(node[0]).right = map.get(node[1]);
                
            }
        }



        return root;
    }
}