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
    int max = Integer.MIN_VALUE;
    private void makeGraph(TreeNode root, Map<Integer, List<Integer>> adj){
        max = Math.max(max, root.val);
        if(root.left!=null){
            adj.computeIfAbsent(root.val, k-> new ArrayList<>()).add(root.left.val);
            adj.computeIfAbsent(root.left.val, k-> new ArrayList<>()).add(root.val);
            makeGraph(root.left, adj);

        }
        if(root.right!=null){
            adj.computeIfAbsent(root.val, k-> new ArrayList<>()).add(root.right.val);
            adj.computeIfAbsent(root.right.val, k-> new ArrayList<>()).add(root.val);
            makeGraph(root.right, adj);

        }

    }
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        makeGraph(root, adj);
        int time = 0;
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        boolean[] vis = new boolean[max+1];
        vis[start]=true;
        while(!q.isEmpty()){
            int n=q.size();
            while(n-- != 0){
                int node =q.poll();
                for(int nei: adj.getOrDefault(node, new ArrayList<>())){
                    if(!vis[nei]){
                        q.add(nei);
                        vis[nei]=true;

                    }
                }
            }
            time++;
        }
        return time-1;
    }
}