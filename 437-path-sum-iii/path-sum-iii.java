
class Solution {
    HashMap<Long, Integer> map = new HashMap<>();
    int ans=0;
    private void dfs(TreeNode root, int target, long current){
        if(root==null)
            return;
        current += root.val;
        ans+=map.getOrDefault(current-target,0);
        map.put(current, map.getOrDefault(current,0)+1);
        
        dfs(root.left, target, current);
        dfs(root.right, target, current);
        map.put(current, map.get(current)-1);
        if(map.get(current)==0)
            map.remove(current);

    }
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L,1);
        dfs(root, targetSum, 0L);
        return ans;
    }
}