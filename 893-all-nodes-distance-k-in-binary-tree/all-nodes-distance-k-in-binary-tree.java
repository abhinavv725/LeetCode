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
    private void dfs(TreeNode root, Map<TreeNode, List<TreeNode>> adj){
        adj.computeIfAbsent(root, k-> new ArrayList<>());
        if(root.left!=null){
            adj.get(root).add(root.left);
            adj.computeIfAbsent(root.left, k-> new ArrayList<>()).add(root);
            dfs(root.left, adj);

        }
        if(root.right!=null){
            adj.get(root).add(root.right);
            adj.computeIfAbsent(root.right, k-> new ArrayList<>()).add(root);
            dfs(root.right, adj);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>();
        dfs(root, adj);
        if(k==0){
            return Arrays.asList(target.val);
        }
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int step=0;
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        while(!q.isEmpty()){
            ans = new ArrayList<>();
            int n = q.size();
            step++;
            while(n!=0){
                TreeNode curr = q.poll();
                for(TreeNode nei: adj.getOrDefault(curr, new ArrayList<>())){
                    if(!visited.contains(nei)){
                        ans.add(nei.val);
                        q.add(nei);
                        visited.add(nei);
                    }
                    
                }
                n--;
            }
            if(step==k){
                return ans;
            }
        }
        ans = new ArrayList<>();
        return ans;

    }
}