/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private class Node {
        TreeNode root;
        int step;
        Node(TreeNode root, int step){
            this.root=root;
            this.step=step;
        }
    }
    int mini = Integer.MAX_VALUE;
    int maxi = Integer.MIN_VALUE;

    private void bfs(TreeNode root, HashMap<Integer,List<Integer>> map){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));

        while(!q.isEmpty()){
            int n=q.size();
            while(n-- > 0){
                Node curr = q.poll();
                TreeNode currRoot = curr.root;
                int step = curr.step;
                mini = Math.min(step, mini);
                maxi = Math.max(step, maxi);
                if(!map.containsKey(step)){
                    map.put(step, new ArrayList<>());
                }
                map.get(step).add(currRoot.val);

                if(currRoot.left!=null){
                    q.add(new Node(currRoot.left, step-1));
                }
                if(currRoot.right!=null){
                    q.add(new Node(currRoot.right, step+1));
                }
            }
        }

    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        bfs(root, map);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=mini;i<=maxi;i++){
            ans.add(map.get(i));
        }
        // int j=0;
        // for(int i=mini;i<=maxi;i++){
        //     ans.get(j).add(map.get(i));
        //     j++;
        // }
        return ans;
    }
}