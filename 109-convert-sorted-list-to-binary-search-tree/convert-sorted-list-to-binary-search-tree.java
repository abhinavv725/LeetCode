/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev= null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev= slow;
            slow=slow.next;
        }
        if(prev!=null){
            prev.next=null;
        }
        return slow;
    }
    private TreeNode recursion(ListNode head){
        if(head==null)
            return null;

        ListNode middle = middle(head);
        TreeNode root = new TreeNode(middle.val);
        
        if(middle==head)
            return root;
        
        root.left = recursion(head);
        root.right = recursion(middle.next);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        return recursion(head);
    }
}