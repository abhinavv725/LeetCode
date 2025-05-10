
class Solution {
    private class Pair {
        TreeNode node; 
        int step;
        Pair(TreeNode node, int step){
            this.node=node;
            this.step = step;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- >0){
                Pair p = q.poll();
                TreeNode curr = p.node; int step = p.step;
                mini =Math.min(mini, step);
                maxi =Math.max(maxi, step);
                map.computeIfAbsent(step, k-> new ArrayList<>()).add(curr.val);
                if(curr.left!=null){
                    q.add(new Pair(curr.left, step-1));
                }
                if(curr.right!=null){
                    q.add(new Pair(curr.right, step+1));
                }
                

            }
        }
        for(int i=mini;i<=maxi;i++){
            ans.add(map.get(i));
        }
        return ans;
    }
}