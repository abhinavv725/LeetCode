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
    private int findMax(int l, int r,int[] nums){
        if(l>=0 && r>=0 && l<nums.length && r< nums.length){
            int max =nums[l];
            int index=l;
            for(int i=l;i<=r;i++){
                if(nums[i]> max){
                    max=nums[i];
                    index=i;
                }
            }
            return index;
        }
        return -1;
    }
    private TreeNode construct(int l, int r, int[] nums){
        if(l>r){
            return null;
        }
        int maxi = findMax(l,r, nums);
        if(maxi==-1)
            return null;
        
        TreeNode root= new TreeNode(nums[maxi]);
        root.left = construct(l, maxi-1, nums);
        root.right = construct(maxi+1,r, nums);
        return root;

    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(0, nums.length-1, nums);
    }
}