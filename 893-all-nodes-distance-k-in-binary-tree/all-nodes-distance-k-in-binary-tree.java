/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void dfs(TreeNode root, Map<TreeNode,List<TreeNode>> adj){
        adj.computeIfAbsent(root, k-> new ArrayList<>());
        if(root.left!=null){
            adj.get(root).add(root.left);
            adj.computeIfAbsent(root.left, k-> new ArrayList<>());
            adj.get(root.left).add(root);
            dfs(root.left, adj);
        }
        if(root.right!=null){
            adj.get(root).add(root.right);
            adj.computeIfAbsent(root.right, k-> new ArrayList<>());
            adj.get(root.right).add(root);
            dfs(root.right, adj);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(k==0)
            return new ArrayList<>(Arrays.asList(target.val));
        Map<TreeNode,List<TreeNode>> adj = new HashMap<>();
        dfs(root, adj);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        Set<TreeNode> vis = new HashSet<>();
        int step=0;
        vis.add(target);
        while(!q.isEmpty()){
            ans = new ArrayList<>();
            step++;
            int size = q.size();
            while(size-- >0){
                TreeNode curr = q.poll();
                for(TreeNode nei: adj.getOrDefault(curr, new ArrayList<>())){
                    if(!vis.contains(nei)){
                        ans.add(nei.val);
                        q.add(nei);
                        vis.add(nei);

                    }
                }

            }
            if(step==k)
                return ans;

        }
        ans = new ArrayList<>();
        return ans;


    }
}